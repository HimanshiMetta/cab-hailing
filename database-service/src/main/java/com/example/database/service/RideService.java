package com.example.database.service;

import com.example.database.entity.Ride;
import com.example.database.repositiory.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;


    public Ride saveRide(Ride ride) {
        return rideRepository.save(ride);
    }

    public Ride findByRideId(int rideId) {
        return rideRepository.findByRideId(rideId);
    }

    public void updateOngoing(int rideId, boolean ongoing) {
        rideRepository.updateOngoing(rideId, ongoing);
    }
}
