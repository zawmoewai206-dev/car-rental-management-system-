package com.rent.CarRentalManagementSystem.Service;

import java.util.Date;
import java.util.List;

import com.rent.CarRentalManagementSystem.Entity.Car;
import com.rent.CarRentalManagementSystem.Entity.Maintenance;
import com.rent.CarRentalManagementSystem.dao.CarDAO;
import com.rent.CarRentalManagementSystem.dao.MaintenanceDAO;



public class MaintenanceService {

    private MaintenanceDAO mdo = new MaintenanceDAO();
    private CarDAO cdo = new CarDAO();

    // Start Maintenance
    public void startMaintenance(int carId, String problem,Date startDate) {

        Car car = cdo.findById(carId);

        if (car == null) {

            System.out.println("Car not found.");
            return;

        }

        if (car.getStatus().equalsIgnoreCase("RENTED")) {

            System.out.println("Car is currently rented.");
            return;

        }

        if (car.getStatus().equalsIgnoreCase("MAINTENANCE")) {

            System.out.println("Car is already under maintenance.");
            return;

        }

        Maintenance maintenance = new Maintenance();

        maintenance.setCar(car);
        maintenance.setProblem(problem);
        maintenance.setStartDate(startDate);
        maintenance.setEndDate(null);
        

        //Maintain status
        maintenance.setStatus("IN PROGRESS");
        
        mdo.save(maintenance);

        //CAR STATUS
        car.setStatus("MAINTENANCE");
        cdo.update(car);

        System.out.println("Maintenance started successfully.");

    }

    // Finish Maintenance
    public void finishMaintenance(int maintainId,Date endDate) {

        Maintenance maintenance = mdo.findById(maintainId);

        if (maintenance == null) {

            System.out.println("Maintenance record not found.");
            return;

        }

        if (maintenance.getEndDate() != null) {

            System.out.println("Maintenance already completed.");
            return;

        }

        //Maintain Status
        maintenance.setEndDate(endDate);
        maintenance.setStatus("COMPLETED");
        mdo.update(maintenance);
        

        Car car = maintenance.getCar();

        car.setStatus("AVAILABLE");

        cdo.update(car);

        System.out.println("Maintenance completed.");

    }

    // Delete Maintenance
    public void deleteMaintenance(int maintainId) {

        Maintenance maintenance = mdo.findById(maintainId);

        if (maintenance == null) {

            System.out.println("Maintenance record not found.");
            return;

        }

        mdo.delete(maintenance);

        System.out.println("Maintenance record deleted.");

    }

    // Search Maintenance
    public Maintenance getMaintenanceById(int maintainId) {

        return mdo.findById(maintainId);

    }

    // View All Maintenance
    public List<Maintenance> getAllMaintenance() {

        return mdo.findAll();

    }

}
