package com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`slot`")

public class Slot {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "slot_id")
    private int slot_id;

    @Column(name = "slot_name")
    private String slot_name;

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", slot_id=" + slot_id +
                ", slot_name=" + slot_name +
                ", booked=" + booked +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public String getSlot_name() {
        return slot_name;
    }

    public void setSlot_name(String slot_name) {
        this.slot_name = slot_name;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Column(name = "booked")
    private boolean booked;
}
