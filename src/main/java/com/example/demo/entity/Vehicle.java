package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicles", uniqueConstraints = {
        @UniqueConstraint(columnNames = "vehicleNumber")
})
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, unique = true)
    private String vehicleNumber;

    @Column(nullable = false)
    private Double capacityKg;

    @Column(nullable = false)
    private Double fuelEfficiency;

    @OneToMany(mappedBy = "vehicle")
    private List<Shipment> shipments;
}
