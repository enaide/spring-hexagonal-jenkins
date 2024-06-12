package com.ecfcode.hexagonal.infrastracture.demo;

import com.ecfcode.hexagonal.infrastracture.demo.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    Vehicle findByVehicleId(Long vehicleId);
}
