package com.model;

import javax.persistence.*;

@Entity
@Table(name="`user_reg`")
public class RegUser {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "car_number")
    private String car_number;

    @Override
    public String toString() {
        return "RegUser{" +
                "id=" + id +
                ", car_number=" + car_number +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                '}';
    }

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public String getcar_number() {
        return car_number;
    }

    public void setcar_number(String car_number) {
        this.car_number = car_number;
    }

    @Column(name = "dob")
    private String dob;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone")
    private long phone;
    @Column(name = "address")
    private String address;
    public RegUser() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}