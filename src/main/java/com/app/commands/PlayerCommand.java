package com.app.commands;

import io.micronaut.core.annotation.Introspected;

import java.util.List;
import java.util.Optional;

@Introspected
public class PlayerCommand {

    private List<String> playerNameList;

    public Optional<List<String>> getPlayerNameList() {
        return Optional.of(playerNameList);
    }
}
