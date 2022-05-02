package com.service;
import com.model.RegUser;
import com.model.Slot;
import com.model.SlotBookingInformation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

import java.util.List;

@Service("database")
public class DatabaseParkingServiceImpl implements ParkingService {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException ex) {
            session = sessionFactory.openSession();
        }
        return session;
    }


    @Override
    public  List<RegUser> getInfo() {
        List<RegUser> regUserList = getSession().createQuery("from RegUser", RegUser.class).list();
        return regUserList;
    }


    @Override
    public Object countofusers() {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query1 = (Query) session.createNativeQuery("SELECT COUNT(id) FROM user_reg;");
        Object total = (Object) query1.uniqueResult();
        transaction.commit();
        session.close();
        return total;
    }

    @Override
    public Object countofbookings() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query1 = (Query) session.createNativeQuery("SELECT COUNT(id) FROM slot_booking;");
        Object total = (Object) query1.uniqueResult();
        transaction.commit();
        session.close();
        return total;
    }

    @Override
    public Object sumcost() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query1 = (Query) session.createNativeQuery("select sum(parking_cost) from slot_booking;");
        Object total = (Object) query1.uniqueResult();
        transaction.commit();
        session.close();
        return total;
    }

    @Override
    public Object freeslot() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query1 = (Query) session.createNativeQuery("SELECT COUNT(booked) FROM slot WHERE booked=false;");
        Object total = (Object) query1.uniqueResult();
        transaction.commit();
        session.close();
        return total;
    }


    @Override
    public Slot updateByStatus(Slot slot){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(slot);
        transaction.commit();
        session.close();
        return slot;
    }


    @Override
    public  List<SlotBookingInformation> bookingInfo() {
        List<SlotBookingInformation> slotBookingInformations = getSession().createQuery("from SlotBookingInformation", SlotBookingInformation.class).list();
        return slotBookingInformations;
    }

    @Override
    public  List<Slot> slotInfo(){
        List<Slot> slots = getSession().createQuery("from Slot",Slot.class).list();
        return slots;
    }



    @Override
    public RegUser insert(RegUser regUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(regUser);
        transaction.commit();
        session.close();
        return regUser;
    }


    @Override
    public SlotBookingInformation push(SlotBookingInformation slotBookingInformation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(slotBookingInformation);
        transaction.commit();
        session.close();
        return slotBookingInformation;
    }

    @Override
    public SlotBookingInformation removeid(int id) {
        SlotBookingInformation slotBookingInformation = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        slotBookingInformation = session.get(SlotBookingInformation.class,id);
        session.delete(slotBookingInformation);
        transaction.commit();
        session.close();
        return slotBookingInformation;
    }
    @Override
    public SlotBookingInformation getBookingById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        SlotBookingInformation slotBookingInformation = session.get(SlotBookingInformation.class,id);
        transaction.commit();
        session.close();
        return slotBookingInformation;
    }


}
