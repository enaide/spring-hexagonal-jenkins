package com.ecfcode.hexagonal.infrastracture.usecase.abstracts;

import com.ecfcode.hexagonal.infrastracture.usecase.Territory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoryRepository extends JpaRepository<Territory, Long> {
}
