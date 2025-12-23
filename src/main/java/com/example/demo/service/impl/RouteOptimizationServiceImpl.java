package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    @Override
    public RouteOptimizationResult optimize(Shipment shipment) {

        double distance = 100.0; // dummy
        double fuelUsed = distance / shipment.getVehicle().getFuelEfficiency();

        return RouteOptimizationResult.builder()
                .shipment(shipment)
                .distanceKm(distance)
                .fuelUsed(fuelUsed)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
