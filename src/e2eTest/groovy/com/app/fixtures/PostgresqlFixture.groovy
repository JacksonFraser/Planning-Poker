package com.app.fixtures

import com.app.Postgresql

trait PostgresqlFixture {

    Map<String, Object> getPostgresqlConfiguration() {
        if (Postgresql.postgreSQLContainer == null || !Postgresql.postgreSQLContainer.isRunning()) {
            Postgresql.init()
        }
        Map<String, Object> datasource = [
                'datasources.default.url'            : Postgresql.postgreSQLContainer.getJdbcUrl(),
                'datasources.default.password'       : Postgresql.postgreSQLContainer.getPassword(),
                'datasources.default.username'       : Postgresql.postgreSQLContainer.getUsername(),
                'datasources.default.driverClassName': Postgresql.postgreSQLContainer.getDriverClassName(),
                'datasources.default.dialect'        : 'MYSQL'
        ] as HashMap

        datasource
    }
}