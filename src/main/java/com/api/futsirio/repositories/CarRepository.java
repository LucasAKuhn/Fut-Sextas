package com.api.futsirio.repositories;

import com.api.futsirio.entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Cars, Long> {

}
