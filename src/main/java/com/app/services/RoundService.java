package com.app.services;

import com.app.commands.RoundCommand;
import com.app.models.Round;
import com.app.repositories.RoundRepository;

import java.util.List;

public class RoundService {

    private final RoundRepository roundRepository;

    public RoundService(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    public List<Round> getAll() {
        return roundRepository.findAll();
    }

    public void createRound(RoundCommand command) {
        roundRepository.save(Round.builder()
                .description(command.getDescription().orElse(null))
                .build());

    }


}
