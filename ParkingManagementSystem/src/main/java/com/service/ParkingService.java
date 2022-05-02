package com.service;
import com.model.RegUser;
import com.model.Slot;
import com.model.SlotBookingInformation;

import java.util.List;

public interface ParkingService {

    RegUser insert(RegUser regUser);
    List<RegUser> getInfo();


    SlotBookingInformation push(SlotBookingInformation slotBookingInformation);
    List<SlotBookingInformation> bookingInfo();



    SlotBookingInformation removeid(int id);
    SlotBookingInformation getBookingById(int id);

    List<Slot> slotInfo();
    Slot updateByStatus(Slot slot);

    Object countofusers();
    Object countofbookings();
    Object sumcost();
    Object freeslot();




}


