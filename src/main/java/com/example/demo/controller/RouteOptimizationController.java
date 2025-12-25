package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {

    private final RouteOptimizationService routeService;

    public RouteOptimizationController(RouteOptimizationService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/{shipmentId}")
    public ResponseEntity<ApiResponse> optimizeRoute(@PathVariable Long shipmentId) {
        RouteOptimizationResult result = routeService.optimizeRoute(shipmentId);
        return ResponseEntity.ok(new ApiResponse(true, "Route optimized successfully", result));
    }

    @GetMapping("/result/{resultId}")
    public ResponseEntity<ApiResponse> getResult(@PathVariable Long resultId) {
        RouteOptimizationResult result = routeService.getResult(resultId);
        return ResponseEntity.ok(new ApiResponse(true, "Result retrieved successfully", result));
    }
}