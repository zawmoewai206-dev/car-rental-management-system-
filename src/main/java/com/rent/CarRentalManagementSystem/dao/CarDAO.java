package com.rent.CarRentalManagementSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rent.CarRentalManagementSystem.Entity.Car;
import com.rent.CarRentalManagementSystem.util.HibernateUtil;

public class CarDAO {
	
//add
	public void save(Car car) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.save(car);

		tx.commit();
		session.close();
	}
	
//update
	public void update(Car car) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.update(car);

		tx.commit();
		session.close();
	}

//delete 
	public void delete(Car car) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.delete(car);

		tx.commit();
		session.close();
	}

//search Car
	public Car findById(int carId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Car car = (Car) session.get(Car.class, carId);

		session.close();

		return car;
	}

//View All car
	@SuppressWarnings("unchecked")
	public List<Car> fingAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List<Car> list = session.createQuery("from Car").list();

			return list;
		} finally {
			session.close();
		}
	}

}
