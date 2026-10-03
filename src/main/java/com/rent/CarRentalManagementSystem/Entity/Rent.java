package com.rent.CarRentalManagementSystem.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Rent")
public class Rent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rent_id")
	private int rentId;

	@ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

	@ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

	@Temporal(TemporalType.DATE)
	@Column(name = "rent_date")
	private Date rentDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "return_date")
	private Date returnDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "actual_return_date")
	private Date actualReturnDate;
	
	@Column(name = "penalty_fee")
	private double penaltyFee;

	@Column(name = "rent_status")
	private String rentStatus;

	public int getRentId() {
		return rentId;
	}

	public void setRentId(int rentId) {
		this.rentId = rentId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getActualReturnDate() {
		return actualReturnDate;
	}

	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}

	public double getPenaltyFee() {
		return penaltyFee;
	}

	public void setPenaltyFee(double penalty) {
		this.penaltyFee = penalty;
	}

	public String getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
	}

	public Rent() {
	}

	// Display ID
	public String getDisplayRentId() {
		return String.format("R-%04d", rentId);
	}

	@Override
	public String toString() {
		return "Rent ID               : " + getDisplayRentId() + 
				"\nCustomer ID        : " + customer.getDisplayCustomerId() + 
				"\nCar ID             : "+ car.getDisplayCarId() + 
				"\nRent DATE          : " + rentDate + 
				"\nReturn DATE        : " + returnDate + 
				"\nActual Return DATE : "+ actualReturnDate + 
				"\nPenalty Fee        : " + penaltyFee + 
				"\nRent Status        : " + rentStatus;
	}

}
