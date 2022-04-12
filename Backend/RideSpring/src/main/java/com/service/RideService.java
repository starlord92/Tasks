package com.service;

import com.model.Ride;

import java.util.List;

public interface RideService {

    List<Ride> getRide();
    Ride getRideByPrice(int RidePrice);
    Ride createRideType(Ride ride);
    Ride updateRideByPrice(Ride ride);
    Ride deleteRideByPrice(int price);


}


