package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouteOptimizationResult {
    private String route;
    private double distance;
    private Shipment shipment; // already added from previous fix
    private double fuelUsed;   // <-- ADD THIS
}
