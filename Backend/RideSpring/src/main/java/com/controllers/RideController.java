package com.controllers;

import com.model.Ride;
import com.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class RideController {
    @Qualifier("database")
    @Autowired
    RideService rideService;
    @GetMapping("/ride")
    public List<Ride> getRide(){
        return rideService.getRide();
    }
    @GetMapping("/get/{price}")
    public Ride getRideByPrice(@PathVariable("price") int RidePrice){

        return rideService.getRideByPrice(RidePrice);
    }
    @PostMapping("/create")
    public Ride createRideType(@RequestBody Ride ride){
        rideService.createRideType(ride);
        return ride;
    }
    @PutMapping("/update/{price}")
    public Ride updateRideByPrice(@PathVariable("price") Integer rideprice,
                                  @RequestBody Ride ride){

        rideService.updateRideByPrice(ride);
        return ride;
    }
    @DeleteMapping("/remove/{price}")
    public Ride deleteRideByPrice(@PathVariable("price") Integer rideprice){
        Ride ride = getRideByPrice(rideprice);
      rideService.deleteRideByPrice(rideprice);
      return ride;
    }

}