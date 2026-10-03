package com.rent.CarRentalManagementSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rent.CarRentalManagementSystem.Entity.Customer;
import com.rent.CarRentalManagementSystem.util.HibernateUtil;

public class CustomerDAO {

	public void save(Customer customer) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.save(customer);

		tx.commit();
		session.close();
	}

	public void update(Customer customer) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.save(customer);

		tx.commit();
		session.close();
	}

	public void delete(Customer customer) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.delete(customer);

		tx.commit();
		session.close();
	}

	public Customer findByid(int customerId) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Customer customer = (Customer) session.get(Customer.class, customerId);

		session.close();

		return customer;

	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Customer> list = session.createQuery("from Customer").list();
		
		session.close();
		
		return list;

	}

}
