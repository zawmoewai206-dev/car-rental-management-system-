package com.rent.CarRentalManagementSystem.Service;

import java.util.List;

import com.rent.CarRentalManagementSystem.Entity.Customer;
import com.rent.CarRentalManagementSystem.dao.CustomerDAO;

public class CustomerService {

	private CustomerDAO cudo = new CustomerDAO();

	public void addCustomer(Customer customer) {
		
		if (!isValidEmail(customer.getEmail())) {

	        System.out.println("Invalid email format.");
	        return;
	    }

		cudo.save(customer);

		System.out.println("Customer added successfully");
	}

	public void updateCustomer(Customer customer) {

		Customer oldCustomer = cudo.findByid(customer.getCustomerId());
          
		if(oldCustomer==null) {
			System.out.println("Customer not found");
			
			return;
		}
		
		if (!isValidEmail(customer.getEmail())) {
	        System.out.println("Invalid email format.");
	        return;
	    }

	    oldCustomer.setName(customer.getName());
	    oldCustomer.setPhone(customer.getPhone());
	    oldCustomer.setEmail(customer.getEmail());
	    oldCustomer.setLicense_no(customer.getLicense_no());
	    
	    
		cudo.update(oldCustomer);
		System.out.println("Customer updated successfully");
	}
	
	public void deleteCustomer(int customerId) {
		
		Customer customer=cudo.findByid(customerId);
		
		if (customer==null) {
			System.out.println("Customer not found");
			return;
		}
		cudo.delete(customer);
		System.out.println("Customer delete successfully");
	}
	
	public Customer getCustomerById(int customerId) {
	
		return cudo.findByid(customerId);
		
	}
	
	public List<Customer>getAllCustomer(){
		return cudo.findAll();
	}
	
	private boolean isValidEmail(String email) {

	    return email != null &&
	           email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
	}
	

}
