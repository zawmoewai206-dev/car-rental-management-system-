package com.rent.CarRentalManagementSystem.menu;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.rent.CarRentalManagementSystem.Entity.Rent;
import com.rent.CarRentalManagementSystem.Service.RentService;


 public class RentMenu {

    private Scanner sc = new Scanner(System.in);
    private RentService rentService = new RentService();

    public void rentMenu() {

        int choice;

        do {

            System.out.println();
            System.out.println("============= Rent Management =============");
            System.out.println("1. Rent Car");
            System.out.println("2. Return Car");
            System.out.println("3. View Current Rent");
            System.out.println("4. View Rent History");
            System.out.println("5. Search Rent");
            System.out.println("0. Back");
            System.out.print("Enter choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:
                rentCar();
                break;

            case 2:
                returnCar();
                break;

            case 3:
                viewCurrentRent();
                break;

            case 4:
                viewRentHistory();
                break;

            case 5:
                searchRent();
                break;

            case 0:
                System.out.println("Back to Main Menu...");
                break;

            default:
                System.out.println("Invalid Choice!");

            }

        } while (choice != 0);

    }

    // Rent Car
    private void rentCar() {

        try {

            System.out.print("Customer ID : ");
            int customerId = sc.nextInt();

            System.out.print("Car ID : ");
            int carId = sc.nextInt();

            sc.nextLine();

            System.out.print("Rent Date (yyyy-MM-dd) : ");
            String rentDateStr = sc.nextLine();

            System.out.print("Return Date (yyyy-MM-dd) : ");
            String returnDateStr = sc.nextLine();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date rentDate = sdf.parse(rentDateStr);
            Date returnDate = sdf.parse(returnDateStr);

            rentService.rentCar(customerId, carId, rentDate, returnDate);

        } catch (ParseException e) {

            System.out.println("Invalid Date Format.");

        }

    }

    // Return Car
    private void returnCar() {

        try {

            System.out.print("Rent ID : ");
            int rentId = sc.nextInt();

            sc.nextLine();

            System.out.print("Actual Return Date (yyyy-MM-dd) : ");
            String date = sc.nextLine();

            Date actualReturnDate =
                    new SimpleDateFormat("yyyy-MM-dd").parse(date);

            rentService.returnCar(rentId, actualReturnDate);

        } catch (ParseException e) {

            System.out.println("Invalid Date Format.");

        }

    }

    // View Current Rent
    private void viewCurrentRent() {

        List<Rent> list = rentService.getCurrentRent();

        for (Rent r : list) {

        	System.out.println("----------------------------------------");
        	System.out.println("Rent ID            : " + r.getDisplayRentId());
        	System.out.println(r.getCustomer());
        	System.out.println(r.getCar());
        	System.out.println("Rent Date          : " + r.getRentDate());
        	System.out.println("Return Date        : " + r.getReturnDate());
        	System.out.println("Actual Return Date : " + r.getActualReturnDate());
        	System.out.println("Penalty Fee        : " + r.getPenaltyFee());
        	System.out.println("Rent Status        : " + r.getRentStatus());

        }

    }

    // View Rent History
    private void viewRentHistory() {

        List<Rent> list = rentService.getReturnedRent();

        for (Rent r : list) {

            System.out.println("----------------------------------------");
            System.out.println(r);

        }

    }

    // Search Rent
    private void searchRent() {

        System.out.print("Rent ID : ");
        int id = sc.nextInt();

        Rent r = rentService.getRentById(id);

        if (r == null) {

            System.out.println("Rent record not found.");
            return;

        }

        System.out.println("----------------------------------------");
        System.out.println(r);

    }

}
