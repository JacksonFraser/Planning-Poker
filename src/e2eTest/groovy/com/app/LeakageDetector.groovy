package com.app

import com.app.fixtures.RepositoriesFixtures

trait LeakageDetector extends RepositoriesFixtures {

    boolean hasLeakage() {
        return playerRepository.count() > 0 ||
                roundPlayerRepository.count() > 0 ||
                roundRepository.count() > 0
    }

}