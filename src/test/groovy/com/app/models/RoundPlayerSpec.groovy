package com.app.models

import com.app.helper.TestEntityBuilder
import com.app.repositories.RoundPlayerRepository
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class RoundPlayerSpec extends Specification implements TestEntityBuilder {

    @Inject
    RoundPlayerRepository roundPlayerRepository

    void " Adding player to round creates a round_player row"() {
        when:
        Player player = buildPlayer()
        Round round = buildRound(players: [player])

        then:
        roundPlayerRepository.findAll().size() == 1
        RoundPlayer roundPlayer = roundPlayerRepository.findAll().first()
        roundPlayer.playerId == player.id
        roundPlayer.roundId == round.id
    }

    void " Adding round to player creates a round_player row"() {
        when:
        Round round = buildRound()
        Player player = buildPlayer(rounds: [round])

        then:
        roundPlayerRepository.findAll().size() == 1
        RoundPlayer roundPlayer = roundPlayerRepository.findAll().first()
        roundPlayer.playerId == player.id
        roundPlayer.roundId == round.id
    }

    void " Adding multiple rounds to player creates a round_player row"() {
        when:
        buildPlayer(rounds: [buildRound(), buildRound()])

        then:
        roundPlayerRepository.findAll().size() == 2
    }

    void " Adding multiple players to round creates a round_player row"() {
        when:
        buildRound(players: [buildPlayer(name: "Benny Greb"), buildPlayer(name: "Jojo Mayer")])

        then:
        roundPlayerRepository.findAll().size() == 2
    }
}
