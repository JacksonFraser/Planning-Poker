package com.app

import com.app.fixtures.ConfigurationFixture
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import planningpoker.client.invoker.ApiClient
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

abstract class ApplicationServerSpecification extends Specification implements ConfigurationFixture, LeakageDetector {


    @AutoCleanup
    @Shared
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer, configuration)

    @AutoCleanup
    @Shared
    ApplicationContext applicationContext = ApplicationContext.run(configuration)


    @Shared
    PlanningPokerClient client = new PlanningPokerClient(new ApiClient())

    def setupSpec() {

    }

    def cleanup() {
        assert !hasLeakage()

    }
}
