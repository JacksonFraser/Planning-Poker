package com.app.repositories;

import com.app.models.Round;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {
}
