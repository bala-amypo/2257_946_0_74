package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@SpringBootTest
public class TransportRouteOptimizationTest {

    @Autowired
    private RouteOptimizationResultRepository routeOptimizationResultRepository; // fixed

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserService userService;

    private JwtUtil jwtUtil;

    private User testUser;
    private UserDetails testUserDetails;

    @BeforeEach
    public void setUp() {
        // use no-arg constructor
        jwtUtil = new JwtUtil();

        // Create test user
        testUser = new User();
        testUser.setName("Test User");
        testUser.setEmail("test@example.com");
        testUser.setPassword("password");
        testUser = userService.register(testUser); // fixed

        testUserDetails = org.springframework.security.core.userdetails.User
                .withUsername(testUser.getEmail())
                .password(testUser.getPassword())
                .roles("USER")
                .build();
    }

    @Test
    public void testRouteOptimization() {
        // Example vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber("TN12345");
        vehicle.setCapacityKg(1000);
        vehicleRepository.save(vehicle);

        // Create dummy route result
        RouteOptimizationResult res = new RouteOptimizationResult();
        res.setOptimizedDistanceKm(120.0); // fixed getter usage
        res.setEstimatedFuelUsageL(15.0);
        routeOptimizationResultRepository.save(res);

        // Validate token
        String token = jwtUtil.generateToken(testUserDetails);
        boolean isValid = jwtUtil.validateToken(token, testUserDetails); // pass UserDetails
        assert isValid;
    }

    @Test
    public void testVehicleRepository() {
        Optional<Vehicle> vehicleOpt = vehicleRepository.findByVehicleNumber("TN12345");
        assert vehicleOpt.isPresent();
    }

}
