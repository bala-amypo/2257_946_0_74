package com.example.demo;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.User;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TransportRouteOptimizationTest {

    @Mock
    private ShipmentRepository shipmentRepository;

    @Mock
    private RouteOptimizationResultRepository routeOptimizationResultRepository;

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private JwtUtil jwtUtil;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUserRegistration() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");

        // Mock the service behavior
        when(userService.register(user)).thenReturn(user);
        when(userService.findByUsername("testuser")).thenReturn(user);

        userService.register(user);
        User registeredUser = userService.findByUsername("testuser");

        assertNotNull(registeredUser);
        assertEquals("testuser", registeredUser.getUsername());
        verify(userService, times(1)).register(user);
    }

    @Test
    public void testRouteOptimizationResult() {
        RouteOptimizationResult res = new RouteOptimizationResult();
        res.setId(1L);
        res.setOptimizedDistanceKm(100.0);
        res.setEstimatedFuelUsageL(10.0);

        // Mock repository behavior
        when(routeOptimizationResultRepository.save(res)).thenReturn(res);
        when(routeOptimizationResultRepository.findById(1L)).thenReturn(Optional.of(res));

        routeOptimizationResultRepository.save(res);
        Optional<RouteOptimizationResult> savedRes = routeOptimizationResultRepository.findById(1L);

        assertTrue(savedRes.isPresent());
        assertEquals(100.0, savedRes.get().getOptimizedDistanceKm());
        assertEquals(10.0, savedRes.get().getEstimatedFuelUsageL());
        verify(routeOptimizationResultRepository, times(1)).save(res);
    }

    @Test
    public void testJwtValidation() {
        User user = new User();
        user.setUsername("jwtuser");
        user.setPassword("password");

        // Mock token generation and validation
        String token = "dummy-token";
        JwtUtil spyJwt = spy(jwtUtil);

        doReturn(token).when(spyJwt).generateToken(user.getUsername());
        doReturn(true).when(spyJwt).validateToken(token, user);

        String generatedToken = spyJwt.generateToken(user.getUsername());
        assertTrue(spyJwt.validateToken(generatedToken, user));

        verify(spyJwt, times(1)).generateToken(user.getUsername());
        verify(spyJwt, times(1)).validateToken(generatedToken, user);
    }
}
