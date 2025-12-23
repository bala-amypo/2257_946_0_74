package com.example.demo;

import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TransportRouteOptimizationTest {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private RouteOptimizationResultRepository routeOptimizationResultRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserService userService;

    private JwtUtil jwtUtil;

    @BeforeEach
    public void setup() {
        // Use default constructor of JwtUtil
        jwtUtil = new JwtUtil();
    }

    @Test
    public void testUserRegistration() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        userService.register(user);

        User registeredUser = userService.findByUsername("testuser");
        assertNotNull(registeredUser);
        assertEquals("testuser", registeredUser.getUsername());
    }

    @Test
    public void testRouteOptimizationResult() {
        RouteOptimizationResult res = new RouteOptimizationResult();
        res.setOptimizedDistanceKm(100.0);
        res.setEstimatedFuelUsageL(10.0);

        routeOptimizationResultRepository.save(res);

        Optional<RouteOptimizationResult> savedRes = routeOptimizationResultRepository.findById(res.getId());
        assertTrue(savedRes.isPresent());
        assertEquals(100.0, savedRes.get().getOptimizedDistanceKm());
        assertEquals(10.0, savedRes.get().getEstimatedFuelUsageL());
    }

    @Test
    public void testJwtValidation() {
        User user = new User();
        user.setUsername("jwtuser");
        user.setPassword("password");
        userService.register(user);

        String token = jwtUtil.generateToken(user.getUsername());
        assertTrue(jwtUtil.validateToken(token, user));
    }

    // Add more tests as needed
}
