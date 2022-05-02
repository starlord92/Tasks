package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`slot_booking`")
public class SlotBookingInformation {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "slot_id")
    private int slot_id;

    @Override
    public String toString() {
        return "SlotBookingInformation{" +
                "id=" + id +
                ", slot_id=" + slot_id +
                ", car_number=" + car_number +
                ", user_name='" + user_name + '\'' +
                ", date='" + date + '\'' +
                ", start_time='" + start_time + '\'' +
                ", parking_hrs='" + parking_hrs + '\'' +
                ", endtime='" + endtime + '\'' +
                ", parking_cost=" + parking_cost +
                '}';
    }

    public String getcar_number() {
        return car_number;
    }

    public void setcar_number(String car_number) {
        this.car_number = car_number;
    }

    @Column(name = "car_number")
    private String car_number;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "date")
    private String date;
    @Column(name = "start_time")
    private String start_time;
    @Column(name = "parking_hrs")
    private String parking_hrs;
    @Column(name = "endtime")
    private String endtime;
    @Column(name = "parking_cost")
    private int parking_cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getParking_hrs() {
        return parking_hrs;
    }

    public void setParking_hrs(String parking_hrs) {
        this.parking_hrs = parking_hrs;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getParking_cost() {
        return parking_cost;
    }

    public void setParking_cost(int parking_cost) {
        this.parking_cost = parking_cost;
    }

}
