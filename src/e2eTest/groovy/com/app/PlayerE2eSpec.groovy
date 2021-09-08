package com.app

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
}
