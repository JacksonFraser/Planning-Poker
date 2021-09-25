package com.app.tests

import com.app.ApplicationServerSpecification
import com.app.models.Player

class PlayerE2eSpec extends ApplicationServerSpecification {


    void "Can do a thing"() {
        when: "the thing happens"
        buildPlayer(name: name)


        then: "it did in fact happen"
        playerRepository.findByName(name)

        cleanup: "but also, let's pretend it didn't"
        playerRepository.deleteAll()

        where:
        name = "Art Blaky"
    }

    void "ui"() {
        given:
        buildPlayer(name: name)

        when:
        List<Player> playerList = client.playerApi.getAll()

        then:
        playerList.size() == 1

        cleanup: "but also, let's pretend it didn't"
        playerRepository.deleteAll()

        where:
        name = "bob name"
    }

    void "ui create"() {
        given:
        buildPlayer(name: name)

        when:
        List<Player> playerList = client.playerApi.cr

        then:
        playerList.size() == 1

        cleanup: "but also, let's pretend it didn't"
        playerRepository.deleteAll()

        where:
        name = "bob name"
    }
}
