package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    private Double optimizedDistanceKm;
    private Double estimatedFuelUsageL;

    private LocalDateTime generatedAt;

    // ✅ REQUIRED BY SERVICE
    public RouteOptimizationResult(
            Shipment shipment,
            Double optimizedDistanceKm,
            Double estimatedFuelUsageL,
            LocalDateTime generatedAt
    ) {
        this.shipment = shipment;
        this.optimizedDistanceKm = optimizedDistanceKm;
        this.estimatedFuelUsageL = estimatedFuelUsageL;
        this.generatedAt = generatedAt;
    }
}
