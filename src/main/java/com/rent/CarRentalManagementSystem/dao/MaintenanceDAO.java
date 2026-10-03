package com.rent.CarRentalManagementSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rent.CarRentalManagementSystem.Entity.Maintenance;
import com.rent.CarRentalManagementSystem.util.HibernateUtil;

public class MaintenanceDAO {
	
	public void save(Maintenance maintenance) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(maintenance);
		
		tx.commit();
		session.close();
	}
	
	public void update(Maintenance maintenance) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(maintenance);

        tx.commit();
        session.close();
    }

    public void delete(Maintenance maintenance) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.delete(maintenance);

        tx.commit();
        session.close();
    }

    public Maintenance findById(int maintainId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Maintenance maintenance =
                (Maintenance) session.get(Maintenance.class, maintainId);

        session.close();

        return maintenance;
    }

    @SuppressWarnings("unchecked")
    public List<Maintenance> findAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Maintenance> list =
                session.createQuery("from Maintenance").list();

        session.close();

        return list;
    }

}
