package com.model;

import javax.persistence.*;

@Entity
@Table(name="`RIDE`")
public class Ride {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RidePrice")
    private int RidePrice;

    @Column(name = "RideDuration")
    private String RideDuration;

    @Column(name = "RideType")
    private String RideType;

    public Ride() {

    }

    public int getRidePrice() {
        return RidePrice;
    }

    public void setRidePrice(int ridePrice) {
        RidePrice = ridePrice;
    }

    public String getRideDuration() {
        return RideDuration;
    }

    public void setRideDuration(String rideDuration) {
        RideDuration = rideDuration;
    }

    public String getRideType() {
        return RideType;
    }

    public void setRideType(String rideType) {
        RideType = rideType;
    }
}