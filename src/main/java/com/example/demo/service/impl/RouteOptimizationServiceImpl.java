package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;

    public RouteOptimizationServiceImpl(
            ShipmentRepository shipmentRepository,
            RouteOptimizationResultRepository resultRepository) {
        this.shipmentRepository = shipmentRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public RouteOptimizationResult optimize(Long shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        double distance = 120.5; // dummy
        double fuelUsed = distance / shipment.getVehicle().getFuelEfficiency();

        RouteOptimizationResult result = RouteOptimizationResult.builder()
                .shipment(shipment)
                .totalDistance(distance)
                .fuelUsed(fuelUsed)
                .optimizedAt(LocalDateTime.now())
                .build();

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long shipmentId) {
        return resultRepository.findByShipmentId(shipmentId)
                .orElseThrow(() -> new RuntimeException("Result not found"));
    }
}
