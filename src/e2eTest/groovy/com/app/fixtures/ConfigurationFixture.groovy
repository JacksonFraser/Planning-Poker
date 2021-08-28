package com.app.fixtures


trait ConfigurationFixture implements PostgresqlFixture {


    Map<String, Object> getConfiguration() {
        Map<String, Object> m = [:
        ] as HashMap

        if (specName) {
            m['spec.name'] = specName
        }


        Map<String, Object> datasource = postgresqlConfiguration
        println("datasource config " + datasource)
        m += datasource

        m
    }

    String getSpecName() {
        null
    }
}