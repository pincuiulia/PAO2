package service;

import daoServices.LocationRepositoryService;
import model.Location;

import java.util.Scanner;

public class LocationService {

    private LocationRepositoryService databaseService;

    public LocationService(LocationRepositoryService databaseService) {
        this.databaseService = databaseService;
    }

    public void addLocation(Scanner scanner) {
        System.out.println("Enter location details:");
        System.out.println("City:");
        String city = scanner.nextLine();
        System.out.println("Address:");
        String address = scanner.nextLine();
        System.out.println("Capacity:");
        int capacity = Integer.parseInt(scanner.nextLine());
        databaseService.addLocation(city, address, capacity);
    }

    public void removeLocation(Scanner scanner) {
        System.out.println("Enter the city of the location to remove:");
        String city = scanner.nextLine();
        Location location = databaseService.getLocationByCity(city);
        if (location != null) {
            databaseService.removeLocation(location);
        } else {
            System.out.println("Location not found.");
        }
    }

    public void readLocation(Scanner scanner) {
        System.out.println("Enter the city of the location to find:");
        String city = scanner.nextLine();
        databaseService.getLocationByCity(city);
    }
}
