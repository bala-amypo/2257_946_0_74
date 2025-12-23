package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class RouteOptimizationResult {
    private String route;
    private double distance;
    private Shipment shipment; // already added
    private double fuelUsed;   // already added
    private LocalDateTime createdAt; // <-- ADD THIS
}
