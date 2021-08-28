package com.app.commands;

import io.micronaut.core.annotation.NonNull;

import java.util.Optional;

public class RoundCommand {

    @NonNull
    private Long id;

    private String description;


    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public Long getId() {
        return id;
    }

}
