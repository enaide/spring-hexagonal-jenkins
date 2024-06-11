package com.ecfcode.hexagonal.infrastracture.repository;

import com.ecfcode.hexagonal.infrastracture.entities.codejava.demo.Vehicle;
import com.ecfcode.hexagonal.infrastracture.repository.abstracts.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle findVehicleById(Long vehicleId) {
        return vehicleRepository.findByVehicleId(vehicleId);
    }

    public List<Vehicle> findAllVehicleById(List<Long> vehicleIds) {
        return (List<Vehicle>) vehicleRepository.findAllById(vehicleIds);
    }
}
