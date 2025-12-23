package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double latitude;

    private Double longitude;

    // Pickup location relationship
    @OneToMany(mappedBy = "pickupLocation")
    private List<Shipment> pickupShipments;

    // Drop location relationship
    @OneToMany(mappedBy = "dropLocation")
    private List<Shipment> dropShipments;

    // No-arg constructor
    public Location() {}

    // Parameterized constructor (JUST assigns)
    public Location(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // getters & setters
}
