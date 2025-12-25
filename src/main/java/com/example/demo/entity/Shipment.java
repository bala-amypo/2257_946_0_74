package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "shipments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "pickup_location_id")
    private Location pickupLocation;

    @ManyToOne
    @JoinColumn(name = "drop_location_id")
    private Location dropLocation;

    private Double weightKg;

    private LocalDate scheduledDate;

    // Parameterized constructor as per requirement
    public Shipment(Vehicle vehicle, Location pickupLocation, Location dropLocation, Double weightKg, LocalDate scheduledDate) {
        this.vehicle = vehicle;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.weightKg = weightKg;
        this.scheduledDate = scheduledDate;
    }
}