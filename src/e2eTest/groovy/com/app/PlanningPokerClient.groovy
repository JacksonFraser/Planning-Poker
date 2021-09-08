package com.app

import planningpoker.client.api.DefaultApi
import planningpoker.client.api.PlayerApi
import planningpoker.client.invoker.ApiClient

class PlanningPokerClient {

    private ApiClient client

    PlanningPokerClient(ApiClient client) {
        this.client = client
    }

    PlayerApi playerApi() {
        return new PlayerApi(client)
    }

    DefaultApi defaultApi() {
        return new DefaultApi(client)
    }
}
