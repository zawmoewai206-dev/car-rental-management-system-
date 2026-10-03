package com.rent.CarRentalManagementSystem.Service;


import java.util.Date;
import java.util.List;

import com.rent.CarRentalManagementSystem.Entity.Car;
import com.rent.CarRentalManagementSystem.Entity.Customer;
import com.rent.CarRentalManagementSystem.Entity.Rent;
import com.rent.CarRentalManagementSystem.dao.CarDAO;
import com.rent.CarRentalManagementSystem.dao.CustomerDAO;
import com.rent.CarRentalManagementSystem.dao.RentDAO;


 public class RentService {

    private RentDAO rdo = new RentDAO();
    private CarDAO cdo = new CarDAO();
    private CustomerDAO cudo = new CustomerDAO();

    // Rent Car
    public void rentCar(int customerId, int carId,
                        Date rentDate, Date returnDate) {

        Customer customer = cudo.findByid(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        Car car = cdo.findById(carId);

        if (car == null) {
            System.out.println("Car not found.");
            return;
        }

        if (car.getStatus().equalsIgnoreCase("RENTED")) {
            System.out.println("Car is already rented.");
            return;
        }

        if (car.getStatus().equalsIgnoreCase("MAINTENANCE")) {
            System.out.println("Car is under maintenance.");
            return;
        }

        Rent rent = new Rent();

        rent.setCustomer(customer);
        rent.setCar(car);
        rent.setRentDate(rentDate);
        rent.setReturnDate(returnDate);
        rent.setRentStatus("RENTED");
        rent.setPenaltyFee(0);

        rdo.save(rent);

        car.setStatus("RENTED");
        cdo.update(car);

        System.out.println("Rent completed successfully.");
    }

    // Return Car
    public void returnCar(int rentId, Date actualReturnDate) {

        Rent rent = rdo.findById(rentId);

        if (rent == null) {
            System.out.println("Rent record not found.");
            return;
        }

        if (rent.getRentStatus().equalsIgnoreCase("RETURNED")) {
            System.out.println("Car already returned.");
            return;
        }

        rent.setActualReturnDate(actualReturnDate);

        double penalty = 0;

        if (actualReturnDate.after(rent.getReturnDate())) {

            long milliseconds =
                    actualReturnDate.getTime()
                    - rent.getReturnDate().getTime();

            long latedays =
                    milliseconds / (1000 * 60 * 60 * 24);

            penalty = latedays * 2000;
        }

        rent.setPenaltyFee(penalty);
        rent.setRentStatus("RETURNED");

        rdo.update(rent);

        Car car = rent.getCar();

        car.setStatus("AVAILABLE");

        cdo.update(car);

        System.out.println("Return completed.");
        System.out.println("Penalty Fee : " + penalty);

    }

    // Search
    public Rent getRentById(int rentId) {

        return rdo.findById(rentId);

    }

    // View All
    public List<Rent> getAllRent() {

        return rdo.findAll();

    }

    // Current Rent
    public List<Rent> getCurrentRent() {

        return rdo.findCurrentRent();

    }

    // Returned History
    public List<Rent> getReturnedRent() {

        return rdo.findReturnedRent();

    }

}
