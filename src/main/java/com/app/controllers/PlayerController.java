package com.app.controllers;

import com.app.models.Player;
import com.app.services.PlayerService;
import io.micronaut.data.model.Page;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;

@Controller("/player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Get
    public Page<Player> getAll() {
        return playerService.getAll();
    }

    @Post("/create/{name}")
    @Status(HttpStatus.CREATED)
    public Player createPlayer(String name) {
        return playerService.createPlayer(name);
    }
}
