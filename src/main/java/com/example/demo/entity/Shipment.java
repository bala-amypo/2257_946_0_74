package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    private double weightKg;

    private LocalDate scheduledDate;
}
