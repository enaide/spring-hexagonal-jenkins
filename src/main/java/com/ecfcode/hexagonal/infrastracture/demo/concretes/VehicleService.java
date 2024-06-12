package com.ecfcode.hexagonal.infrastracture.demo.concretes;

import com.ecfcode.hexagonal.infrastracture.demo.entities.Vehicle;
import com.ecfcode.hexagonal.infrastracture.demo.VehicleRepository;
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
