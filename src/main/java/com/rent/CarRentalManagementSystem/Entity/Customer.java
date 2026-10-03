package com.rent.CarRentalManagementSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="customer_id")
		private int customerId;
		
		@Column(name="name")
		private String name;
		
		@Column(name="phone")
		private String phone;
		
		@Column(name="email")
		private String email;
		
		@Column(name="license_no")
		private String license_no;
		
        public Customer() {
			
		}
		
		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getLicense_no() {
			return license_no;
		}

		public void setLicense_no(String license_no) {
			this.license_no = license_no;
		}
		
		// Display ID (Console UI)
	    public String getDisplayCustomerId() {
	        return String.format("CU-%04d", customerId);
	    }
		@Override
		public String toString() {
		    return "Customer ID   : " + getDisplayCustomerId() +
		           "\nName        : " + name +
		           "\nPhone       : " + phone +
		           "\nEmail       : " + email +
		           "\nLicense No  : " + license_no;
		}
	}
