package com.app

import planningpoker.client.api.DefaultApi
import planningpoker.client.api.PlayerApi
import planningpoker.client.invoker.ApiClient

class PlanningPokerClient {


    private ApiClient client

    PlanningPokerClient(ApiClient client) {
        client.setBasePath("http://localhost:8080/planning-poker")
        this.client = client
    }

    PlayerApi getPlayerApi() {
        return new PlayerApi(client)
    }

    DefaultApi getDefaultApi() {
        return new DefaultApi(client)
    }
}
