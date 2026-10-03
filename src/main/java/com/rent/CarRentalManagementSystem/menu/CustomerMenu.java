package com.rent.CarRentalManagementSystem.menu;

import java.util.List;
import java.util.Scanner;

import com.rent.CarRentalManagementSystem.Entity.Customer;
import com.rent.CarRentalManagementSystem.Service.CustomerService;

public class CustomerMenu {

    private Scanner sc = new Scanner(System.in);
    private CustomerService customerService = new CustomerService();

    public void customerMenu() {

        int choice;

        do {

            System.out.println();
            System.out.println("========== Customer Management ==========");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("0. Back");
            System.out.print("Enter choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:
                addCustomer();
                break;

            case 2:
                viewAllCustomers();
                break;

            case 3:
                searchCustomer();
                break;

            case 4:
                updateCustomer();
                break;

            case 5:
                deleteCustomer();
                break;

            case 0:
                System.out.println("Back to Main Menu...");
                break;

            default:
                System.out.println("Invalid Choice!");

            }

        } while (choice != 0);

    }

    // Add Customer
    private void addCustomer() {

        Customer customer = new Customer();

        sc.nextLine();

        System.out.print("Name : ");
        customer.setName(sc.nextLine());

        System.out.print("Phone : ");
        customer.setPhone(sc.nextLine());

        System.out.print("Email : ");
        customer.setEmail(sc.nextLine());
        
        System.out.print("License No : ");
        customer.setLicense_no(sc.nextLine());

        customerService.addCustomer(customer);

    }
    // View All
    private void viewAllCustomers() {

        List<Customer> list = customerService.getAllCustomer();

        for (Customer c : list) {

            System.out.println("----------------------------");
            System.out.println(c);

        }

    }

    // Search
    private void searchCustomer() {

        System.out.print("Customer ID : ");
        int id = sc.nextInt();

        Customer c = customerService.getCustomerById(id);

        if (c == null) {

            System.out.println("Customer not found.");
            return;

        }

        System.out.println("----------------------------");
        System.out.println(c);

    }

    // Update
    private void updateCustomer() {

        Customer customer = new Customer();

        System.out.print("Name : ");
        customer.setName(sc.nextLine());

        System.out.print("Phone : ");
        customer.setPhone(sc.nextLine());

        System.out.print("Email : ");
        customer.setEmail(sc.nextLine());
        
        System.out.print("License No : ");
        customer.setLicense_no(sc.nextLine());

        customerService.updateCustomer(customer);

    }

    // Delete
    private void deleteCustomer() {

        System.out.print("Customer ID : ");

        int id = sc.nextInt();

        customerService.deleteCustomer(id);

    }

}