package com.app

import org.testcontainers.containers.PostgreSQLContainer

class Postgresql {

    static PostgreSQLContainer postgreSQLContainer

    static init() {
        if (postgreSQLContainer == null) {
            postgreSQLContainer = new PostgreSQLContainer('postgres:13-alpine')

            // Reuse container between tests instead of starting a new one per execution
            postgreSQLContainer
                    .withReuse(true)
                    .withNetwork(null)
                    .withLabel("com.app", "postgresqlTestContainersReuse")
                    .start()
        }
    }
}