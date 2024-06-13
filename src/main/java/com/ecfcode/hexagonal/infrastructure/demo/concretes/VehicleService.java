package com.ecfcode.hexagonal.infrastructure.demo.concretes;

import com.ecfcode.hexagonal.infrastructure.demo.entities.Vehicle;
import com.ecfcode.hexagonal.infrastructure.demo.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle findVehicleById(Long vehicleId) {
        return vehicleRepository.findByVehicleId(vehicleId);
    }

    public List<Vehicle> findAllVehicleById(List<Long> vehicleIds) {
        return (List<Vehicle>) vehicleRepository.findAllById(vehicleIds);
    }
}
