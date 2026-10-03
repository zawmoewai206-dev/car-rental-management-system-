package com.rent.CarRentalManagementSystem.menu;

import java.util.List;
import java.util.Scanner;

import com.rent.CarRentalManagementSystem.Entity.Car;
import com.rent.CarRentalManagementSystem.Service.CarService;

public class CarMenu {

    private Scanner sc = new Scanner(System.in);
    private CarService carService = new CarService();

    public void carMenu() {

        int choice;

        do {

            System.out.println();
            System.out.println("============= Car Management =============");
            System.out.println("1. Add Car");
            System.out.println("2. View All Cars");
            System.out.println("3. Search Car");
            System.out.println("4. Update Car");
            System.out.println("5. Delete Car");
            System.out.println("0. Back");
            System.out.print("Enter choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:
                addCar();
                break;

            case 2:
                viewAllCars();
                break;

            case 3:
                searchCar();
                break;

            case 4:
                updateCar();
                break;

            case 5:
                deleteCar();
                break;

            case 0:
                System.out.println("Back to Main Menu...");
                break;

            default:
                System.out.println("Invalid Choice!");

            }

        } while (choice != 0);

    }

    // Add Car
    private void addCar() {

        Car car = new Car();
        
        

        sc.nextLine();

        System.out.print("Brand : ");
        car.setBrand(sc.nextLine());

        System.out.print("Model : ");
        car.setModel(sc.nextLine());

        System.out.print("Car Number : ");
        car.setCarNo(sc.nextLine());

        System.out.print("Price Per Day : ");
        car.setPricePerDay(sc.nextDouble());

        carService.addCar(car);

    }

    // View All Cars
    private void viewAllCars() {

        List<Car> list = carService.getAllCar();

        for (Car car : list) {

            System.out.println("------------------------------------");
            System.out.println(car);

        }

    }

    // Search Car
    private void searchCar() {

        System.out.print("Car ID : ");
        int id = sc.nextInt();

        Car car = carService.getCarById(id);

        if (car == null) {

            System.out.println("Car not found.");
            return;

        }

        System.out.println("------------------------------------");
        System.out.println(car);

    }

    // Update Car
    private void updateCar() {

        Car car = new Car();

        System.out.print("Car ID : ");
        car.setCarId(sc.nextInt());

        sc.nextLine();

        System.out.print("Brand : ");
        car.setBrand(sc.nextLine());

        System.out.print("Model : ");
        car.setModel(sc.nextLine());

        System.out.print("Car Number : ");
        car.setCarNo(sc.nextLine());

        System.out.print("Price Per Day : ");
        car.setPricePerDay(sc.nextDouble());

        carService.updateCar(car);

    }

    // Delete Car
    private void deleteCar() {

        System.out.print("Car ID : ");

        int id = sc.nextInt();

        carService.deleteCar(id);

    }

}
