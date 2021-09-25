package com.app.tests

import com.app.ApplicationServerSpecification

class DefaultE2ESpec extends ApplicationServerSpecification {


    void 'test it works'() {
        expect:
        applicationContext.isRunning()
    }
}
