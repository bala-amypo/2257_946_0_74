package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pickup_location_id")
    private Location pickupLocation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "drop_location_id")
    private Location dropLocation;

    private Double weightKg;

    private LocalDate scheduledDate;

    // No-arg constructor
    public Shipment() {}

    // Parameterized constructor (JUST assigns)
    public Shipment(Vehicle vehicle,
                    Location pickupLocation,
                    Location dropLocation,
                    Double weightKg,
                    LocalDate scheduledDate) {
        this.vehicle = vehicle;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.weightKg = weightKg;
        this.scheduledDate = scheduledDate;
    }

    // getters & setters
}
