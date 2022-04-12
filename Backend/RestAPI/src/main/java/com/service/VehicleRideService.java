<<<<<<< HEAD
package com.service;

import com.model.RideDetails;
import com.model.Vehicle;

import java.sql.SQLException;
import java.util.List;

public interface VehicleRideService {
        List<Vehicle> getVehicles() ;
        List<Vehicle> sortVehicles();
        List<RideDetails> getRideDetails();
        Vehicle getVehicleById(int VehicleId);
        Vehicle createVehicle(Vehicle vehicle);
        Vehicle updateVehicle(Vehicle vehicle) throws SQLException;
        Vehicle deleteVehicle(Vehicle vehicle) throws SQLException;
        RideDetails getRideByPrice(int price);


}
=======
package com.service;

import com.model.RideDetails;
import com.model.Vehicle;

import java.sql.SQLException;
import java.util.List;

public interface VehicleRideService {
        List<Vehicle> getVehicles() ;
        List<Vehicle> sortVehicles();
        List<RideDetails> getRideDetails();
        Vehicle getVehicleById(int VehicleId);
        Vehicle createVehicle(Vehicle vehicle);
        Vehicle updateVehicle(Vehicle vehicle) throws SQLException;
        Vehicle deleteVehicle(Vehicle vehicle) throws SQLException;
        RideDetails getRideByPrice(int price);


}
>>>>>>> 462d7d809c697d99b10f64ea1c43cc46231c114d
