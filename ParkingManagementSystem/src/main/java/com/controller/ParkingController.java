package com.controller;

import com.model.RegUser;
import com.model.Slot;
import com.model.SlotBookingInformation;
import com.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ParkingController {
    @Qualifier("database")
    @Autowired
    ParkingService parkingService;

    public ParkingController() {
    }

    @GetMapping("/info")
    public List<RegUser> getInfo() {
        return parkingService.getInfo();
    }

    @GetMapping("/slotinfo")
    public List<Slot> slotInfo() {
        return parkingService.slotInfo();
    }


    @GetMapping("/view")
    public List<SlotBookingInformation> bookingInfo() {
        return parkingService.bookingInfo();
    }


    @RequestMapping("/create")
    public RegUser createUser(@RequestBody RegUser regUser) {
        parkingService.insert(regUser);
        return regUser;
    }

    @RequestMapping("/push")
    public SlotBookingInformation createUser(@RequestBody SlotBookingInformation slotBookingInformation) {
        System.out.println(slotBookingInformation);
        parkingService.push(slotBookingInformation);
        return slotBookingInformation;
    }

    @GetMapping("/countofusers")
    public Object countofusers(){return parkingService.countofusers();}

    @GetMapping("/sumcost")
    public Object sumcost(){return parkingService.sumcost();}

    @GetMapping("/countofbookings")
    public Object countofbookings(){return parkingService.countofbookings();}

    @GetMapping("/freeslot")
    public Object freeslot(){return parkingService.freeslot();}

    @DeleteMapping(value = "/remove/{id}")
    public Integer deleteid(@PathVariable("id") int id) {
        SlotBookingInformation slotBookingInformation = getBookingById(id);
        parkingService.removeid(id);
        return id;
    }

    @GetMapping("/get/{id}")
    public SlotBookingInformation getBookingById(@PathVariable("id") int id) {
        return parkingService.getBookingById(id);
    }

    @PutMapping("/update")
    public Object updateByStatus(
            @RequestBody Slot slot) {
        return parkingService.updateByStatus(slot);
    }


}
