package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity // <-- Add this
@Table(name = "route_optimization_results") // optional, customize table name
@Data
@Builder
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    private String route;

    private double distance;

    @OneToOne(cascade = CascadeType.ALL)
    private Shipment shipment; // Assuming Shipment is also an @Entity

    private double fuelUsed;

    private LocalDateTime createdAt;
}
