package com.app

class DefaultE2ESpec extends ApplicationServerSpecification {


    void 'test it works'() {
        expect:
        applicationContext.isRunning()
    }
}
