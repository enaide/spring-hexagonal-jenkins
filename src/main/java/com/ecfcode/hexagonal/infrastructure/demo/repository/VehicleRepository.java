package com.ecfcode.hexagonal.infrastructure.demo.repository;

import com.ecfcode.hexagonal.infrastructure.demo.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    Vehicle findByVehicleId(Long vehicleId);
}
