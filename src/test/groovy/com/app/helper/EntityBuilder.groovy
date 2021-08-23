package com.app.helper

import com.app.PlayerRepository
import com.app.models.Player
import io.micronaut.context.ApplicationContext
import spock.lang.Shared

import javax.inject.Inject

trait EntityBuilder {

    @Shared
    @Inject
    ApplicationContext context

    Player buildPlayer(Map givenValues = [:]) {

        Map values = [
                name: "Bobby Jarzombek"

        ] + givenValues

        return context.getBean(PlayerRepository).with {
            return findByName(values.name).orElseGet({
                return save(Player.builder()
                        .id(1)
                        .name(values.name)
                        .build())
            })
        }
    }
}