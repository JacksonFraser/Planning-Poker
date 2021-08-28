package com.app.models

import com.app.helper.TestEntityBuilder
import com.app.repositories.RoundRepository
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class RoundSpec extends Specification implements TestEntityBuilder {

    @Inject
    RoundRepository roundRepository

    void "Can save a round"() {
        when: "We save a round"
        buildRound(
                result: resultField,
                description: description)

        then: "The round has been saved with the correct values"
        Round round = roundRepository.findAll().first()
        round.description == description
        round.result == resultField

        where:
        resultField | description
        10g         | "a description"
        10g         | null
    }

    void "Can save a round with a single player"() {
        when: "we save a round with a player"
        buildRound(players: [buildPlayer(name: "wacko")])

        then: "the round has been saved with the player"
        roundRepository.findAll().size() == 1
        roundRepository.findAll().first().players.size() == 1
        roundRepository.findAll().first().players.first().name == "wacko"
    }

    /*
     *TODO putting  [buildPlayer(name: "fred"), buildPlayer(name: "barny")]
     * inside a where: block doesn't work because the PlayerRepo appears to not be in the Application Context?
     */

    void "Can save a round with multiple players"() {
        when: "we save a round with a player"
        buildRound(players: [buildPlayer(name: "fred"), buildPlayer(name: "barny")])

        then: "the round has been saved with the player"
        roundRepository.findAll().size() == 1
        roundRepository.findAll().first().players.size() == 2
    }
}
