<<<<<<< HEAD
package com.service;

import com.connection.ForConnection;
import com.model.RideDetails;
import com.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VehicleRideServiceImpl implements VehicleRideService {
    public static ForConnection forConnection = new ForConnection();

    @Override
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicleList=new ArrayList<Vehicle>();

        try {

            Connection con = forConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from vehicle");
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();

                vehicle.setVehicleId(rs.getInt("VehicleId"));
                vehicle.setVehicleName(rs.getString("vehicleName"));
                vehicleList.add(vehicle);

            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> sortVehicles() {
        List<Vehicle> vehicleList=new ArrayList<Vehicle>();
        vehicleList = getVehicles();
        Collections.sort(vehicleList, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {

                return o1.getVehicleName().compareTo(o2.getVehicleName());
            }
        });
        return vehicleList;
    }

    @Override
    public List<RideDetails> getRideDetails() {
        List<RideDetails> rideDetailsList=new ArrayList<RideDetails>();
        try {
            Connection con = forConnection.getConnection();

            PreparedStatement ps = con.prepareStatement("select * from ride");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RideDetails rideDetails = new RideDetails();
                rideDetails.setPrice(rs.getInt(1));
                rideDetails.setDuration(rs.getString(2));

                rideDetailsList.add(rideDetails);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rideDetailsList;
    }




    @Override
    public Vehicle getVehicleById(int VehicleId) {
        Vehicle vehicle=new Vehicle();
        List<Vehicle> vehicleList=new ArrayList<Vehicle>();

        try{
            Connection con=ForConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from vehicle where id=?");
            ps.setInt(1,VehicleId);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                vehicle.setVehicleId(rs.getInt(1));
                vehicle.setVehicleName(rs.getString(2));
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return vehicle;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        try {
            List<Vehicle> vehicleList = new ArrayList<Vehicle>();
            Connection con = ForConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into vehicle VALUES(?,?)");
            ps.setInt(1,vehicle.getVehicleId());
            ps.setString(2,vehicle.getVehicleName());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return vehicle;
    }



    @Override
    public Vehicle updateVehicle(Vehicle vehicle) throws SQLException {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        Connection con = ForConnection.getConnection();
        Statement stmt = con.createStatement();
        PreparedStatement ps = con.prepareStatement("update vehicle set VehicleId=?,VehicleName=? where VehicleId=" + vehicle.getVehicleId());
        ps.setInt(1, vehicle.getVehicleId());
        ps.setString(2, vehicle.getVehicleName());
        ps.executeUpdate();
        con.close();


        return vehicle;
    }

    @Override
    public Vehicle deleteVehicle(Vehicle vehicle) throws SQLException {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        Connection con = ForConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from vehicle where VehicleId="+vehicle.getVehicleId());
        ps.executeUpdate();
        con.close();
        return vehicle;
    }

    @Override
    public RideDetails getRideByPrice(int price) {
        RideDetails rideDetails = new RideDetails();
        List<RideDetails> rideDetailsList = new ArrayList<RideDetails>();

        try {
            Connection con = ForConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from ride where price=?");
            ps.setInt(1, price);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rideDetails.setPrice(rs.getInt(1));
                rideDetails.setDuration(rs.getString(2));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rideDetails;
    }}




=======
package com.service;

import com.connection.ForConnection;
import com.model.RideDetails;
import com.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VehicleRideServiceImpl implements VehicleRideService {
    public static ForConnection forConnection = new ForConnection();

    @Override
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicleList=new ArrayList<Vehicle>();

        try {

            Connection con = forConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from vehicle");
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();

                vehicle.setVehicleId(rs.getInt("VehicleId"));
                vehicle.setVehicleName(rs.getString("vehicleName"));
                vehicleList.add(vehicle);

            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> sortVehicles() {
        List<Vehicle> vehicleList=new ArrayList<Vehicle>();
        vehicleList = getVehicles();
        Collections.sort(vehicleList, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {

                return o1.getVehicleName().compareTo(o2.getVehicleName());
            }
        });
        return vehicleList;
    }

    @Override
    public List<RideDetails> getRideDetails() {
        List<RideDetails> rideDetailsList=new ArrayList<RideDetails>();
        try {
            Connection con = forConnection.getConnection();

            PreparedStatement ps = con.prepareStatement("select * from ride");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RideDetails rideDetails = new RideDetails();
                rideDetails.setPrice(rs.getInt(1));
                rideDetails.setDuration(rs.getString(2));

                rideDetailsList.add(rideDetails);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rideDetailsList;
    }




    @Override
    public Vehicle getVehicleById(int VehicleId) {
        Vehicle vehicle=new Vehicle();
        List<Vehicle> vehicleList=new ArrayList<Vehicle>();

        try{
            Connection con=ForConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from vehicle where id=?");
            ps.setInt(1,VehicleId);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                vehicle.setVehicleId(rs.getInt(1));
                vehicle.setVehicleName(rs.getString(2));
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return vehicle;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        try {
            List<Vehicle> vehicleList = new ArrayList<Vehicle>();
            Connection con = ForConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into vehicle VALUES(?,?)");
            ps.setInt(1,vehicle.getVehicleId());
            ps.setString(2,vehicle.getVehicleName());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return vehicle;
    }



    @Override
    public Vehicle updateVehicle(Vehicle vehicle) throws SQLException {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        Connection con = ForConnection.getConnection();
        Statement stmt = con.createStatement();
        PreparedStatement ps = con.prepareStatement("update vehicle set VehicleId=?,VehicleName=? where VehicleId=" + vehicle.getVehicleId());
        ps.setInt(1, vehicle.getVehicleId());
        ps.setString(2, vehicle.getVehicleName());
        ps.executeUpdate();
        con.close();


        return vehicle;
    }

    @Override
    public Vehicle deleteVehicle(Vehicle vehicle) throws SQLException {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        Connection con = ForConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from vehicle where VehicleId="+vehicle.getVehicleId());
        ps.executeUpdate();
        con.close();
        return vehicle;
    }

    @Override
    public RideDetails getRideByPrice(int price) {
        RideDetails rideDetails = new RideDetails();
        List<RideDetails> rideDetailsList = new ArrayList<RideDetails>();

        try {
            Connection con = ForConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from ride where price=?");
            ps.setInt(1, price);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rideDetails.setPrice(rs.getInt(1));
                rideDetails.setDuration(rs.getString(2));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rideDetails;
    }}




>>>>>>> 462d7d809c697d99b10f64ea1c43cc46231c114d
