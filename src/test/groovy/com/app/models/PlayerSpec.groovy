package com.app.models

import com.app.PlayerRepository
import com.app.helper.EntityBuilder
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class PlayerSpec extends Specification implements EntityBuilder {

    @Inject
    PlayerRepository repository

    void "can save a player"() {
        when:
        buildPlayer(name: "Steve")

        then:
        repository.findByName("Steve")

    }
}
