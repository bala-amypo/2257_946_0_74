package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shipments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(optional = false)
    @JoinColumn(name = "source_location_id")
    private Location sourceLocation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "destination_location_id")
    private Location destinationLocation;

    @Column(nullable = false)
    private Double weightKg;

    // 🔴 THIS FIELD WAS MISSING
    @Column(nullable = false)
    private LocalDateTime scheduledDate;

    @Column
    private Double distanceKm;

    @Column
    private Double fuelUsed;

    @PrePersist
    public void prePersist() {
        if (scheduledDate == null) {
            scheduledDate = LocalDateTime.now();
        }
    }
}
