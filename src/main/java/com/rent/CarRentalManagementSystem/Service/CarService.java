package com.rent.CarRentalManagementSystem.Service;

import java.util.List;

import com.rent.CarRentalManagementSystem.Entity.Car;
import com.rent.CarRentalManagementSystem.dao.CarDAO;

public class CarService {

	private CarDAO cdo = new CarDAO();

	// Add Car
	public void addCar(Car car) {

		car.setStatus("AVAILABLE");
		cdo.save(car);

		System.out.println("Car added successfully");
	}

	// Update Car

	public void updateCar(Car car) {

		Car oldCar = cdo.findById(car.getCarId());
		if (oldCar == null) {
			System.out.println("Car not found!");
			return;
		}
		oldCar.setBrand(car.getBrand());
		oldCar.setModel(car.getModel());
		oldCar.setCarNo(car.getCarNo());
		oldCar.setPricePerDay(car.getPricePerDay());
		
		cdo.update(oldCar);
		System.out.println("Car updated successfully.");
	}

	// Delete Car

	public void deleteCar(int carId) {

		Car car = cdo.findById(carId);

		if (car == null) {
			System.out.println("Car not found!");
			return;
		}

		if ("RENTED".equalsIgnoreCase(car.getStatus())) {
			System.out.println("Can not delete.Car is rented.");
			return;

		}
		if ("MAINTENANCE".equalsIgnoreCase(car.getStatus())) {
			System.out.println("Can not delete.Car is under maintenance");
			return;
		}
		cdo.delete(car);
		System.out.println("Car delete successfully.");
	}

	// Search
	public Car getCarById(int carId) {
		if (carId <= 0) {
			System.out.println("Invalid Car ID!");
			return null;
		}
		return cdo.findById(carId);
	}

	// view All car
	public List<Car> getAllCar() {
		return cdo.fingAll();
	}

}
