package com.rent.CarRentalManagementSystem.menu;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.rent.CarRentalManagementSystem.Entity.Maintenance;
import com.rent.CarRentalManagementSystem.Service.MaintenanceService;



public class MaintenanceMenu {

    private Scanner sc = new Scanner(System.in);
    private MaintenanceService maintenanceService = new MaintenanceService();

    public void maintenanceMenu() {

        int choice;

        do {

            System.out.println();
            System.out.println("========= Maintenance Management =========");
            System.out.println("1. Start Maintenance");
            System.out.println("2. Finish Maintenance");
            System.out.println("3. View All Maintenance");
            System.out.println("4. Search Maintenance");
            System.out.println("5. Delete Maintenance");
            System.out.println("0. Back");
            System.out.print("Enter choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:
                startMaintenance();
                break;

            case 2:
                finishMaintenance();
                break;

            case 3:
                viewAllMaintenance();
                break;

            case 4:
                searchMaintenance();
                break;

            case 5:
                deleteMaintenance();
                break;

            case 0:
                System.out.println("Back to Main Menu...");
                break;

            default:
                System.out.println("Invalid Choice!");

            }

        } while (choice != 0);

    }

    // Start Maintenance
    private void startMaintenance() {

        try {

            System.out.print("Car ID : ");
            int carId = sc.nextInt();

            sc.nextLine();

            System.out.print("Problem : ");
            String problem = sc.nextLine();

            System.out.print("Start Date (yyyy-MM-dd) : ");
            String date = sc.nextLine();

            Date startDate =
                    new SimpleDateFormat("yyyy-MM-dd").parse(date);

            maintenanceService.startMaintenance(carId, problem, startDate);

        } catch (ParseException e) {

            System.out.println("Invalid Date Format.");

        }

    }

    // Finish Maintenance
    private void finishMaintenance() {

        try {

            System.out.print("Maintenance ID : ");
            int maintainId = sc.nextInt();

            sc.nextLine();

            System.out.print("End Date (yyyy-MM-dd) : ");
            String date = sc.nextLine();

            Date endDate =
                    new SimpleDateFormat("yyyy-MM-dd").parse(date);

            maintenanceService.finishMaintenance(maintainId, endDate);

        } catch (ParseException e) {

            System.out.println("Invalid Date Format.");

        }

    }

    // View All
    private void viewAllMaintenance() {

        List<Maintenance> list =
                maintenanceService.getAllMaintenance();

        for (Maintenance m : list) {

            System.out.println("--------------------------------");
            System.out.println(m);

        }

    }

    // Search
    private void searchMaintenance() {

        System.out.print("Maintenance ID : ");
        int id = sc.nextInt();

        Maintenance m =
                maintenanceService.getMaintenanceById(id);

        if (m == null) {

            System.out.println("Maintenance record not found.");
            return;

        }

        System.out.println("--------------------------------");
        System.out.println(m);

    }

    // Delete
    private void deleteMaintenance() {

        System.out.print("Maintenance ID : ");
        int id = sc.nextInt();

        maintenanceService.deleteMaintenance(id);

    }

}
