<<<<<<< HEAD
package com.servlet;

import com.connection.ForConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.RideDetails;
import com.model.Vehicle;
import com.service.VehicleRideService;
import com.service.VehicleRideServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class VehicleRideServlet extends HttpServlet {
    private static Gson GSON = new GsonBuilder().create();
    ForConnection fc = new ForConnection();
    private static VehicleRideService vehicleService = new VehicleRideServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       if(request.getPathInfo() == null){
           List<Vehicle> vehicles = vehicleService.getVehicles();
           List<Vehicle> vehicleList = vehicleService.sortVehicles();
           List<RideDetails> rideDetailsList = vehicleService.getRideDetails();

           response.setStatus(200);
           response.setHeader("Content-Type","application/json");
           response.getOutputStream().println(GSON.toJson(vehicles));
           response.getOutputStream().println(GSON.toJson(vehicleList));
           response.getOutputStream().println(GSON.toJson(rideDetailsList));
       }else{
           int VehicleId = Integer.parseInt(request.getPathInfo().replace("/",""));
           Vehicle vehicle = vehicleService.getVehicleById(VehicleId);
           if(vehicle != null){
               response.setStatus(200);
               response.setHeader("Content-Type","application/json");
               response.getOutputStream().println(GSON.toJson(vehicle));
           }else{
               response.setStatus(404);
           }
       }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        Vehicle vehicle = GSON.fromJson(request.getReader(), Vehicle.class);
        vehicleService.createVehicle(vehicle);

        response.setStatus(201);
        response.setHeader("Content-Type","application/json");
        response.getOutputStream().println(GSON.toJson("Success"));
    }
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Vehicle vehicle =GSON.fromJson(req.getReader(),Vehicle.class);
        try {
            vehicleService.updateVehicle(vehicle);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        res.setStatus(201);
        res.setHeader("Content-Type","application/json");
        res.getOutputStream().println(GSON.toJson("Success"));
    }
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Vehicle vehicle =GSON.fromJson(req.getReader(),Vehicle.class);
        try {
            vehicleService.deleteVehicle(vehicle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.setStatus(201);
        res.setHeader("Content-Type","application/json");
        res.getOutputStream().println(GSON.toJson("Deleted"));
    }

}
=======
package com.servlet;

import com.connection.ForConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.RideDetails;
import com.model.Vehicle;
import com.service.VehicleRideService;
import com.service.VehicleRideServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class VehicleRideServlet extends HttpServlet {
    private static Gson GSON = new GsonBuilder().create();
    ForConnection fc = new ForConnection();
    private static VehicleRideService vehicleService = new VehicleRideServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       if(request.getPathInfo() == null){
           List<Vehicle> vehicles = vehicleService.getVehicles();
           List<Vehicle> vehicleList = vehicleService.sortVehicles();
           List<RideDetails> rideDetailsList = vehicleService.getRideDetails();

           response.setStatus(200);
           response.setHeader("Content-Type","application/json");
           response.getOutputStream().println(GSON.toJson(vehicles));
           response.getOutputStream().println(GSON.toJson(vehicleList));
           response.getOutputStream().println(GSON.toJson(rideDetailsList));
       }else{
           int VehicleId = Integer.parseInt(request.getPathInfo().replace("/",""));
           Vehicle vehicle = vehicleService.getVehicleById(VehicleId);
           if(vehicle != null){
               response.setStatus(200);
               response.setHeader("Content-Type","application/json");
               response.getOutputStream().println(GSON.toJson(vehicle));
           }else{
               response.setStatus(404);
           }
       }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        Vehicle vehicle = GSON.fromJson(request.getReader(), Vehicle.class);
        vehicleService.createVehicle(vehicle);

        response.setStatus(201);
        response.setHeader("Content-Type","application/json");
        response.getOutputStream().println(GSON.toJson("Success"));
    }
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Vehicle vehicle =GSON.fromJson(req.getReader(),Vehicle.class);
        try {
            vehicleService.updateVehicle(vehicle);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        res.setStatus(201);
        res.setHeader("Content-Type","application/json");
        res.getOutputStream().println(GSON.toJson("Success"));
    }
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Vehicle vehicle =GSON.fromJson(req.getReader(),Vehicle.class);
        try {
            vehicleService.deleteVehicle(vehicle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.setStatus(201);
        res.setHeader("Content-Type","application/json");
        res.getOutputStream().println(GSON.toJson("Deleted"));
    }

}
>>>>>>> 462d7d809c697d99b10f64ea1c43cc46231c114d
