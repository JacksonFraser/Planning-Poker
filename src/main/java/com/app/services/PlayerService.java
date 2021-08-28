package com.app.services;

import com.app.models.Player;
import com.app.repositories.PlayerRepository;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Transactional
@Singleton
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Page<Player> getAll() {
        return Page.of(playerRepository.findAll(), Pageable.UNPAGED, 100);
    }


    public Player createPlayer(@NonNull String name) {
        return playerRepository.save(Player.builder()
                .name(name)
                .build());
    }

    public void removePlayer(@NonNull String name) {
        playerRepository.delete(playerRepository.findByName(name).orElseThrow());
    }
}
