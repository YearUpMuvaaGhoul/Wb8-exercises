package com.pluralsight;

import java.util.List;


import java.util.ArrayList; // Import ArrayList
import java.util.List; // Import List interface

public class Dealership {
    // Attributes for dealership information
    private String name; // Name of the dealership
    private String address; // Address of the dealership
    private String phone; // Contact phone number for the dealership
    private ArrayList<Vehicle> inventory; // List to hold the vehicles in the dealership

    // Variables for buyer and leaser information
    private String buyerName; // Name of the buyer
    private String lesseeName; // Name of the lessee
    private double salePrice; // Sale price of the vehicle
    private double leaseAmount; // Lease amount of the vehicle

    // Constructor to initialize the dealership with name, address, and phone
    public Dealership(String name, String address, String phone) {
        this.name = name; // Set the dealership name
        this.address = address; // Set the dealership address
        this.phone = phone; // Set the dealership phone number
        this.inventory = new ArrayList<>(); // Instantiate the inventory ArrayList to hold vehicles
    }

    // Method to set buyer information
    public void setBuyerInfo(String buyerName, double salePrice) {
        this.buyerName = buyerName; // Set the buyer's name
        this.salePrice = salePrice; // Set the sale price
    }

    // Method to set lessee information
    public void setLesseeInfo(String lesseeName, double leaseAmount) {
        this.lesseeName = lesseeName; // Set the lessee's name
        this.leaseAmount = leaseAmount; // Set the lease amount
    }

    // Method to add a vehicle to the dealership's inventory
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle); // Add the given vehicle to the inventory list
    }

    // Method to retrieve all vehicles in the inventory
    public List<Vehicle> getAllVehicles() {
        return inventory; // Return the entire inventory list
    }

    // Method to get a vehicle by VIN
    public Vehicle getVehicleByVin(int vin) {
        for (Vehicle vehicle : inventory) { // go through all vehicles in the inventory loopity loop
            if (vehicle.getVin() == vin) { // Check if the VIN matches
                return vehicle; // Return the found vehicle
            }
        }
        return null; // Return null if vehicle not found
    }

    // Method to sell a vehicle
    public void sellVehicle(Vehicle vehicle) {
        if (inventory.contains(vehicle)) { // Check if the vehicle is in the inventory
            inventory.remove(vehicle); // Remove the vehicle from inventory
            // Create a record for the sale
            String record = "Sale," + vehicle.getVin() + "," + buyerName + "," + salePrice + "\n";
            DealerShipFileManager fileManager = new DealerShipFileManager("contracts.csv");
            fileManager.writeSalesRecord(record); // Append the record to the contracts file
            System.out.println("Vehicle sold: " + vehicle.getMake() + " " + vehicle.getModel()); // Confirmation message
        } else {
            System.out.println("Vehicle not found in inventory."); // Message if vehicle is not found
        }
    }

    // Method to lease a vehicle
    public void leaseVehicle(Vehicle vehicle) {
        if (inventory.contains(vehicle)) { // Check if the vehicle is in the inventory
            inventory.remove(vehicle); // Remove the vehicle from inventory
            // Create a record for the lease
            String record = "Lease," + vehicle.getVin() + "," + lesseeName + "," + leaseAmount + "\n";
            DealerShipFileManager fileManager = new DealerShipFileManager("contracts.csv");
            fileManager.writeSalesRecord(record); // Append the record to the contracts file
            System.out.println("Vehicle leased: " + vehicle.getMake() + " " + vehicle.getModel()); // Confirmation message
        } else {
            System.out.println("Vehicle not found in inventory."); // Message if vehicle is not found
        }
    }

    // Method to get vehicles within a specified price range
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehiclesInRange = new ArrayList<>(); // Create a list to hold vehicles in the specified price range

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehiclesInRange.add(vehicle); // Add the vehicle to the list if it matches the criteria
            }
        }
        return vehiclesInRange; // Return the list of vehicles within the price range
    }

    // Method to get vehicles by make and model
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> matchingVehicles = new ArrayList<>(); // Create a list to hold matching vehicles

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                matchingVehicles.add(vehicle); // Add the vehicle to the list if it matches
            }
        }
        return matchingVehicles; // Return the list of matching vehicles
    }

    // Method to get vehicles by manufacturing year
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehiclesInYearRange = new ArrayList<>(); // Create a list to hold vehicles within the specified year range

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                vehiclesInYearRange.add(vehicle); // Add the vehicle to the list if it matches the criteria
            }
        }
        return vehiclesInYearRange; // Return the list of vehicles within the year range
    }

    // Method to get vehicles by color
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehiclesByColor = new ArrayList<>(); // Create a list to hold vehicles of the specified color

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                vehiclesByColor.add(vehicle); // Add the vehicle to the list if it matches
            }
        }
        return vehiclesByColor; // Return the list of vehicles of the specified color
    }

    // Method to get vehicles by mileage
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> vehiclesByMileage = new ArrayList<>(); // Create a list to hold vehicles within the specified mileage range

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                vehiclesByMileage.add(vehicle); // Add the vehicle to the list if it matches the criteria
            }
        }
        return vehiclesByMileage; // Return the list of vehicles within the mileage range
    }

    // Method to get vehicles by type (e.g., SUV, Sedan)
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehiclesByType = new ArrayList<>(); // Create a list to hold vehicles of the specified type

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                vehiclesByType.add(vehicle); // Add the vehicle to the list if it matches
            }
        }
        return vehiclesByType; // Return the list of vehicles of the specified type
    }

    // Method to remove a vehicle from the inventory
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle); // Remove the specified vehicle from the inventory list
    }

    // Getters for dealership properties
    public String getName() {
        return name; // Return the name of the dealership
    }

    public String getAddress() {
        return address; // Return the address of the dealership
    }

    public String getPhone() {
        return phone; // Return the phone number of the dealership
    }
}
