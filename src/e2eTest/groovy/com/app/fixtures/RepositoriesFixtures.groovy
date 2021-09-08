package com.app.fixtures

import com.app.models.Player
import com.app.models.Round
import com.app.repositories.PlayerRepository
import com.app.repositories.RoundPlayerRepository
import com.app.repositories.RoundRepository
import io.micronaut.context.ApplicationContext

trait RepositoriesFixtures {

    abstract ApplicationContext getApplicationContext()

    PlayerRepository getPlayerRepository() {
        applicationContext.getBean(PlayerRepository)
    }

    RoundRepository getRoundRepository() {
        applicationContext.getBean(RoundRepository)
    }

    RoundPlayerRepository getRoundPlayerRepository() {
        applicationContext.getBean(RoundPlayerRepository)
    }


    Player buildPlayer(Map givenValues = [:]) {

        Map values = [
                name  : "Bobby Jarzombek",
                rounds: null,
                vote  : 5g

        ] + givenValues

        return playerRepository.with {
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

        return roundRepository.with {
            return save(Round.builder()
                    .players(values.players as HashSet)
                    .description(values.description as String)
                    .result(values.result as BigDecimal)
                    .build())
        }
    }


}