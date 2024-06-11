package com.ecfcode.hexagonal.infrastracture.repository.abstracts;

import com.ecfcode.hexagonal.infrastracture.entities.codejava.demo.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    Vehicle findByVehicleId(Long vehicleId);
}
