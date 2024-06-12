package com.ecfcode.hexagonal.infrastracture.usecase.abstracts;

import com.ecfcode.hexagonal.infrastracture.usecase.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    @Query(value = "SELECT * FROM region r WHERE r.region_id = ?1", nativeQuery = true)
    Optional<Region> findRegionById(Integer id);
}
