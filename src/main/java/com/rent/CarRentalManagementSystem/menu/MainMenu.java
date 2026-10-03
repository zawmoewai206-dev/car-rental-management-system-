package com.rent.CarRentalManagementSystem.menu;

import java.util.Scanner;

public class MainMenu {

    private Scanner sc = new Scanner(System.in);

    private CustomerMenu customerMenu = new CustomerMenu();
    private CarMenu carMenu = new CarMenu();
    private RentMenu rentMenu = new RentMenu();
    private MaintenanceMenu maintenanceMenu = new MaintenanceMenu();

    public void showMainMenu() {

        int choice;

        do {

            System.out.println();
            System.out.println("==========================================");
            System.out.println("      CAR RENTAL MANAGEMENT SYSTEM");
            System.out.println("==========================================");
            System.out.println("1. Customer Management");
            System.out.println("2. Car Management");
            System.out.println("3. Rent Management");
            System.out.println("4. Maintenance Management");
            System.out.println("0. Exit");
            System.out.println("==========================================");
            System.out.print("Enter your choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:
                customerMenu.customerMenu();
                break;

            case 2:
                carMenu.carMenu();
                break;

            case 3:
                rentMenu.rentMenu();
                break;

            case 4:
                maintenanceMenu.maintenanceMenu();
                break;

            case 0:
                System.out.println("Thank you for using Car Rental System.");
                break;

            default:
                System.out.println("Invalid choice! Please try again.");

            }

        } while (choice != 0);

        sc.close();

    }

}