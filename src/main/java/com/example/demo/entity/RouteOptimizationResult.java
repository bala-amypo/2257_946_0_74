package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    private Double optimizedDistanceKm;

    private Double estimatedFuelUsageL;

    private LocalDateTime generatedAt;

    // No-arg constructor
    public RouteOptimizationResult() {}

    // Parameterized constructor (JUST assigns)
    public RouteOptimizationResult(Shipment shipment,
                                   Double optimizedDistanceKm,
                                   Double estimatedFuelUsageL,
                                   LocalDateTime generatedAt) {
        this.shipment = shipment;
        this.optimizedDistanceKm = optimizedDistanceKm;
        this.estimatedFuelUsageL = estimatedFuelUsageL;
        this.generatedAt = generatedAt;
    }

    // getters & setters
}
