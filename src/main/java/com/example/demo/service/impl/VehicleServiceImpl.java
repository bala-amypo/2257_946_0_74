package com.example.demo.service.impl;

import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle save(Vehicle vehicle) {

        if (vehicle.getCapacityKg() <= 0) {
            throw new RuntimeException("Capacity must be positive");
        }

        if (vehicle.getFuelEfficiency() <= 0) {
            throw new RuntimeException("Fuel efficiency must be positive");
        }

        return vehicleRepository.save(vehicle);
    }
}
