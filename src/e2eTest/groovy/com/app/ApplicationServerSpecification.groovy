package com.app

import com.app.fixtures.ConfigurationFixture
import io.micronaut.context.ApplicationContext
import spock.lang.Shared
import spock.lang.Specification

abstract class ApplicationServerSpecification extends Specification implements ConfigurationFixture, LeakageDetector {


    @Shared
    ApplicationContext applicationContext = ApplicationContext.run(configuration)

    def cleanup() {
        assert !hasLeakage()

    }
}
