package com.app.services;

import com.app.commands.PlayerCommand;
import com.app.commands.RoundCommand;
import com.app.models.Player;
import com.app.models.Round;
import com.app.repositories.PlayerRepository;
import com.app.repositories.RoundRepository;

public class RoundPlayerService {

    private final RoundRepository roundRepository;
    private final PlayerRepository playerRepository;

    public RoundPlayerService(RoundRepository roundRepository, PlayerRepository playerRepository) {
        this.roundRepository = roundRepository;
        this.playerRepository = playerRepository;
    }

    public void addPlayersToRound(PlayerCommand playerCommand, RoundCommand roundCommand) {


        playerCommand.getPlayerNameList().orElseThrow().forEach(name -> {
            Player player = playerRepository.findByName(name)
                    .orElse(playerRepository
                            .save(Player.builder()
                                    .name(name)
                                    .build()));
            Round round = roundRepository.findById(roundCommand.getId()).get();
        });


    }
}
