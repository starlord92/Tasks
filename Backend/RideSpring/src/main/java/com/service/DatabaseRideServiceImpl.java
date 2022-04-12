package com.service;

import com.model.Ride;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("database")
public class DatabaseRideServiceImpl implements RideService {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Ride> getRide(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Ride> rideList = session.createQuery("from Ride", Ride.class).list();
        transaction.commit();
        session.close();
        return rideList;
    }

    @Override
    public Ride getRideByPrice(int RidePrice) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Ride ride = session.get(Ride.class,RidePrice);
        transaction.commit();
        session.close();
        return ride;
    }

    @Override
    public Ride createRideType(Ride ride) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ride);
        transaction.commit();
        session.close();
        return ride;
    }

    @Override
    public Ride updateRideByPrice(Ride ride){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(ride);
        transaction.commit();
        session.close();
        return ride;
    }

    @Override
    public Ride deleteRideByPrice(int price) {
        Ride ride = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        ride = session.get(Ride.class,price);
        session.delete(ride);
        transaction.commit();
        session.close();
        return ride;
    }



}
