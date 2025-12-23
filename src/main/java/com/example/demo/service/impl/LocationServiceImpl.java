package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location createLocation(Location location) {
        if (location.getLatitude() == 0 || location.getLongitude() == 0) {
            throw new IllegalArgumentException("Latitude and Longitude must be non-zero");
        }
        return locationRepository.save(location);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
