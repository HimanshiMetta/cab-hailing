package com.example.database.controller;

import com.example.database.entity.Ride;
import com.example.database.service.RideService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@Slf4j
public class ServiceController {

    @Autowired
    private RideService rideService;

    @GetMapping("/saveRide")
    public Ride[] saveRide(@RequestParam int custId,
                           @RequestParam int sourceLoc,
                           @RequestParam int destinationLoc) {

        Ride ride = new Ride(custId, sourceLoc, destinationLoc, false);
        return new Ride[]{rideService.saveRide(ride)};
    }

    @GetMapping("/findByRideId")
    public Ride[] findByRideId(@RequestParam int rideId) {

        Ride ride = rideService.findByRideId(rideId);
        return new Ride[]{ride};
    }

    @GetMapping("/updateOngoing")
    public void updateOngoing(@RequestParam int rideId, @RequestParam boolean ongoing) {

        rideService.updateOngoing(rideId, ongoing);
    }
}
