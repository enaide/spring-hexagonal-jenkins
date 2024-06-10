package com.ecfcode.hexagonal.infrastracture.entities.codejava.airport;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, AirportID> {
}
