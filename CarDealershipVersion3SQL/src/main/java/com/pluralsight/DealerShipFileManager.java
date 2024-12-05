package com.pluralsight;

import java.io.*; // Import for file handling


// Class to handle file operations for the dealership
public class DealerShipFileManager {
    private String fileName; // Name of the file to read/write

    // Constructor to set the file name
    public DealerShipFileManager(String fileName) {
        this.fileName = fileName; // Initialize the file name
    }

    // Method to load the dealership from the file
    public Dealership loadDealership() {
        // Create a new dealership with default values
        Dealership dealership = new Dealership("Default Dealership", "Default Address", "000-000-0000");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) { // Read each line from the file
                String[] fields = line.split("\\|"); // Split by delimiter '|'

                // Check the number of fields and parse accordingly
                if (fields.length >= 8) { // Adjust the number as needed for your data
                    try {
                        int vin = Integer.parseInt(fields[0]); // VIN
                        int year = Integer.parseInt(fields[1]); // Year
                        String make = fields[2]; // Make
                        String model = fields[3]; // Model
                        String vehicleType = fields[4]; // Vehicle Type
                        String color = fields[5]; // Color
                        int odometer = Integer.parseInt(fields[6]); // Odometer
                        double price = Double.parseDouble(fields[7]); // Price

                        // Create a Vehicle object and add it to the dealership
                        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                        dealership.addVehicle(vehicle); // Add vehicle to dealership
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping line due to number format error: " + line);
                    }
                } else {
                    System.out.println("Skipping line due to incorrect field count: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any IOException
        }
        return dealership; // Return the loaded dealership
    }

    // Method to save the dealership to a file
    public void saveDealership(Dealership dealership) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String line = vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|"
                        + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|"
                        + vehicle.getOdometer() + "|" + vehicle.getPrice();
                bw.write(line); // Write each vehicle to the file
                bw.newLine(); // New line after each vehicle
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any IOException
        }
    }

    // Method to write a sales record to the file
    public void writeSalesRecord(String salesRecord) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("sales.csv", true))) { // Append to sales.csv
            bw.write(salesRecord);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle any IOException
        }
    }
}