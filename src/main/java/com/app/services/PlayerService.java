package com.app.services;

import com.app.models.Player;
import com.app.repositories.PlayerRepository;
import io.micronaut.core.annotation.NonNull;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Singleton
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAll() {
        return playerRepository.findAll();
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
