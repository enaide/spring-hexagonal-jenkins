package com.ecfcode.hexagonal.infrastracture.repository.abstracts;

import com.ecfcode.hexagonal.infrastracture.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    @Query(value = "SELECT * FROM region r WHERE r.region_id = ?1", nativeQuery = true)
    Optional<Region> findRegionById(Integer id);
}
