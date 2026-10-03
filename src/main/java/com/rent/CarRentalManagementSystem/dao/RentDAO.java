package com.rent.CarRentalManagementSystem.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rent.CarRentalManagementSystem.Entity.Rent;
import com.rent.CarRentalManagementSystem.util.HibernateUtil;

public class RentDAO {

    // Save
    public void save(Rent rent) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(rent);

        tx.commit();
        session.close();
    }

    // Update
    public void update(Rent rent) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(rent);

        tx.commit();
        session.close();
    }

    // Delete
    public void delete(Rent rent) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.delete(rent);

        tx.commit();
        session.close();
    }

    // Search by ID
    public Rent findById(int rentId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Rent rent = (Rent) session.get(Rent.class, rentId);

        session.close();

        return rent;
    }

    // View All
    @SuppressWarnings("unchecked")
    public List<Rent> findAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Rent> list = session.createQuery("from Rent").list();

        session.close();

        return list;
    }

    // Current Renting
    @SuppressWarnings("unchecked")
    public List<Rent> findCurrentRent() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Rent> list = session.createQuery(
                "from Rent where rentStatus='RENTED'")
                .list();

        session.close();

        return list;
    }

    // Returned History
    @SuppressWarnings("unchecked")
    public List<Rent> findReturnedRent() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Rent> list = session.createQuery(
                "from Rent where rentStatus='RETURNED'")
                .list();

        session.close();

        return list;
    }

}