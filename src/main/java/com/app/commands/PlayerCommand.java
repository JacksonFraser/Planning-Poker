package com.app.commands;

import java.util.List;
import java.util.Optional;

public class PlayerCommand {

    private List<String> playerNameList;

    public Optional<List<String>> getPlayerNameList() {
        return Optional.of(playerNameList);
    }
}
