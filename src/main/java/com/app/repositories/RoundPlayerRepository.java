package com.app.repositories;

import com.app.models.RoundPlayer;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface RoundPlayerRepository extends JpaRepository<RoundPlayer, Long> {
}
