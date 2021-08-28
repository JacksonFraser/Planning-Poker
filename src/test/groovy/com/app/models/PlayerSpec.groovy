package com.app.models

import com.app.helper.TestEntityBuilder
import com.app.repositories.PlayerRepository
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class PlayerSpec extends Specification implements TestEntityBuilder {

    @Inject
    PlayerRepository repository

    void "can save a player"() {
        when: "We save a player"
        buildPlayer(name: "Steve Gadd")

        then: "the player has been saved with the correct values"
        repository.findByName("Steve Gadd")
    }

    void "Can save a player with a single Round"() {
        when: "we save a player"
        buildPlayer(name: "Steve Gadd",
                rounds: [buildRound(result: 20g)])

        then: "The player has been successfully saved"
        Player p = repository.findByName("Steve Gadd").get()
        p.rounds.first().result == 20g
    }

    void "Can save a player with a multiple Rounds"() {
        when: "we save a player"
        buildPlayer(name: "Steve Gadd",
                rounds: [buildRound(), buildRound()])

        then: "The player has been successfully saved"
        Player p = repository.findByName("Steve Gadd").get()
        p.rounds.findAll().size() == 2
    }
}
