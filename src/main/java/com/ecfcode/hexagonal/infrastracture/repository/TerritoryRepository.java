package com.ecfcode.hexagonal.infrastracture.repository;

import com.ecfcode.hexagonal.infrastracture.entities.Territory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoryRepository extends JpaRepository<Territory, Long> {
}
