package com.rent.CarRentalManagementSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Car")
public class Car {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "car_no")
    private String carNo;

    @Column(name = "price_per_day")
    private double pricePerDay;

    @Column(name = "status")
    private String status;

    public Car() {
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
 // Display ID for Console UI
    public String getDisplayCarId() {
        return String.format("C-%04d", carId);
    }

    @Override
    public String toString() {
        return "Car ID         : " + getDisplayCarId() +
               "\nBrand        : " + brand +
               "\nModel        : " + model +
               "\nCar Number   : " + carNo +
               "\nPrice / Day  : " + pricePerDay +
               "\nStatus       : " + status;
    }
    

}
