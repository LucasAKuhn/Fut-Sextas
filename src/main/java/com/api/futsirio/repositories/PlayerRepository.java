package com.api.futsirio.repositories;

import com.api.futsirio.entities.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Players, Long> {

}
