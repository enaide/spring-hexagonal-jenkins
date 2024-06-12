package com.ecfcode.hexagonal.infrastracture.demo.entities.airport;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, AirportID> {
}
