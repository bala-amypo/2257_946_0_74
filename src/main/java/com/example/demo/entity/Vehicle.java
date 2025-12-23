package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(
    name = "vehicles",
    uniqueConstraints = @UniqueConstraint(columnNames = "vehicleNumber")
)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private String vehicleNumber;

    private Double capacityKg;

    private Double fuelEfficiency;

    @OneToMany(mappedBy = "vehicle")
    private List<Shipment> shipments;

    // No-arg constructor
    public Vehicle() {}

    // Parameterized constructor (JUST assigns)
    public Vehicle(User user, String vehicleNumber,
                   Double capacityKg, Double fuelEfficiency) {
        this.user = user;
        this.vehicleNumber = vehicleNumber;
        this.capacityKg = capacityKg;
        this.fuelEfficiency = fuelEfficiency;
    }

    // getters & setters
}
