package com.app.helper

import com.app.models.Player
import com.app.models.Round
import com.app.repositories.PlayerRepository
import com.app.repositories.RoundRepository
import io.micronaut.context.ApplicationContext
import spock.lang.Shared

import javax.inject.Inject

trait TestEntityBuilder {

    @Shared
    @Inject
    ApplicationContext context

    Player buildPlayer(Map givenValues = [:]) {

        Map values = [
                name  : "Bobby Jarzombek",
                rounds: null,
                vote  : 5g

        ] + givenValues

        return context.getBean(PlayerRepository).with {
            return findByName(values.name as String).orElseGet({
                return save(Player.builder()
                        .name(values.name as String)
                        .rounds(values.rounds as HashSet)
                        .vote(values.vote as BigDecimal)
                        .build())
            })
        }
    }

    Round buildRound(Map givenValues = [:]) {
        Map values = [
                players    : null,
                description: "something other than nothing",
                result     : 5g


        ] + givenValues

        return context.getBean(RoundRepository).with {
            return save(Round.builder()
                    .players(values.players as HashSet)
                    .description(values.description as String)
                    .result(values.result as BigDecimal)
                    .build())
        }
    }
}