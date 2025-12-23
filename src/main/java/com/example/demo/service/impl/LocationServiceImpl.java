package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location save(Location location) {

        // primitive double → check range, NOT null
        if (location.getLatitude() < -90 || location.getLatitude() > 90) {
            throw new RuntimeException("Invalid latitude");
        }

        if (location.getLongitude() < -180 || location.getLongitude() > 180) {
            throw new RuntimeException("Invalid longitude");
        }

        return locationRepository.save(location);
    }
}
