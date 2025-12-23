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
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        double distance = 100.0;
        double fuel = 10.0;

        RouteOptimizationResult result = RouteOptimizationResult.builder()
                .shipment(shipment)
                .totalDistance(distance)
                .fuelUsed(fuel)
                .createdAt(LocalDateTime.now())
                .build();

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long shipmentId) {
        return resultRepository.findByShipmentId(shipmentId)
                .orElseThrow(() -> new RuntimeException("Result not found"));
    }
}
