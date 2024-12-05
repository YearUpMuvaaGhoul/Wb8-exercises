package com.pluralsight;


import java.util.ArrayList;
import java.util.List; // Import List for managing collections
import java.util.Scanner; // Import Scanner for user input

//public Dealership currentDealership;
//public ArrayList<Contract> contracts;

// Class to handle the user interface for the dealership
public class UserInterface {
    private Dealership dealership; // This holds the dealership's information
    private Scanner scanner; // Scanner to read user input
    private DealerShipFileManager fileManager; // Handles reading and writing to a file
    public static String filename_dealership = "inventory.csv";
    public static String filename_contracts = "contracts.csv";

    // Constructor to set up the UserInterface with a Dealership
    public UserInterface(Dealership dealership) {
        this.dealership = dealership; // Save the dealership reference
        this.scanner = new Scanner(System.in); // Initialize the scanner to get input
        this.fileManager = new DealerShipFileManager("inventory.csv"); // File to save vehicle data
        loadVehicles(); // Load vehicles from the CSV file when starting the program
    }

    // Method to load vehicles from the file into the dealership
    private void loadVehicles() {
        Dealership loadedDealership = fileManager.loadDealership(); // Load dealership from file
        if (loadedDealership != null) {
            // If we successfully loaded vehicles, add them to our current dealership
            for (Vehicle vehicle : loadedDealership.getAllVehicles()) {
                dealership.addVehicle(vehicle); // Add each vehicle to the dealership
            }
        }
    }

    // Method to start the user interface
    public void start() {
        boolean running = true; // This will control our menu loop

        while (running) { // Keep running until the user decides to exit
            displayMenu(); // Show the menu options
            int choice = scanner.nextInt(); // Get user's choice
            scanner.nextLine(); // Consume the newline character

            // Switch statement to decide what the user wants to do
            switch (choice) {
                case 1:
                    viewAllVehicles(); // Show all vehicles
                    break;
                case 2:
                    addVehicle(); // Add a new vehicle
                    fileManager.saveDealership(dealership); // Save the changes after adding
                    break;
                case 3:
                    findVehiclesByPrice(); // Find vehicles by price range
                    break;
                case 4:
                    findVehiclesByMakeModel(); // Find vehicles by make and model
                    break;
                case 5:
                    findVehiclesByYear(); // Find vehicles by year range
                    break;
                case 6:
                    findVehiclesByColor(); // Find vehicles by color
                    break;
                case 7:
                    sellOrLeaseVehicle(); // Sell or lease a vehicle
                    fileManager.saveDealership(dealership); // Save changes after selling/leasing
                    break;
                case 8:
                    running = false; // Exit the loop
                    break;
                default:
                    System.out.println("Invalid choice, please try again."); // Inform user about invalid input
            }
        }

        System.out.println("Thank you for using the dealership interface."); // Exit message
        scanner.close(); // Close the scanner to free up resources
    }

    // Method to display the menu options
    private void displayMenu() {
        System.out.println("Welcome to the Dealership Interface"); // Greeting
        System.out.println("1. View All Vehicles"); // Option to view all vehicles
        System.out.println("2. Add a Vehicle"); // Option to add a vehicle
        System.out.println("3. Find Vehicles by Price Range"); // Option to find by price
        System.out.println("4. Find Vehicles by Make/Model"); // Option to find by make/model
        System.out.println("5. Find Vehicles by Year Range"); // Option to find by year
        System.out.println("6. Find Vehicles by Color"); // Option to find by color
        System.out.println("7. Sell/Lease a Vehicle"); // New option to sell or lease a vehicle
        System.out.println("8. Exit"); // Option to exit the program
        System.out.print("Please enter your choice: "); // Ask user for input
    }

    // Method to view all vehicles in the dealership
    private void viewAllVehicles() {
        List<Vehicle> vehicles = dealership.getAllVehicles(); // Get the list of vehicles

        if (vehicles.isEmpty()) { // Check if there are no vehicles
            System.out.println("No vehicles available in the inventory."); // Inform user
        } else {
            System.out.println("Vehicles in Inventory:"); // Header for the list
            for (Vehicle vehicle : vehicles) { // Loop through each vehicle
                // Print details for each vehicle
                System.out.println(vehicle.getVin() + ": " + vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
            }
        }
    }

    // Method to add a new vehicle to the dealership
    private void addVehicle() {
        System.out.print("Enter VIN: "); // Ask for VIN
        int vin = scanner.nextInt(); // Read VIN
        System.out.print("Enter Year: "); // Ask for year
        int year = scanner.nextInt(); // Read Year
        System.out.print("Enter Make: "); // Ask for make
        String make = scanner.next(); // Read Make
        System.out.print("Enter Model: "); // Ask for model
        String model = scanner.next(); // Read Model
        System.out.print("Enter Vehicle Type: "); // Ask for vehicle type
        String vehicleType = scanner.next(); // Read Vehicle Type
        System.out.print("Enter Color: "); // Ask for color
        String color = scanner.next(); // Read Color
        System.out.print("Enter Odometer: "); // Ask for odometer reading
        int odometer = scanner.nextInt(); // Read Odometer
        System.out.print("Enter Price: "); // Ask for price
        double price = scanner.nextDouble(); // Read Price

        // Create a new vehicle object
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle); // Add the new vehicle to the dealership

        System.out.println("Vehicle added successfully!"); // Confirm vehicle addition
    }

    // Method to find vehicles by price range
    private void findVehiclesByPrice() {
        System.out.print("Enter minimum price: "); // Ask for minimum price
        double minPrice = scanner.nextDouble(); // Read minimum price
        System.out.print("Enter maximum price: "); // Ask for maximum price
        double maxPrice = scanner.nextDouble(); // Read maximum price

        List<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minPrice, maxPrice); // Find vehicles in the price range
        if (vehiclesByPrice.isEmpty()) {
            System.out.println("No vehicles found in this price range."); // Inform user
        } else {
            System.out.println("Vehicles found in the price range:"); // Header for results
            for (Vehicle vehicle : vehiclesByPrice) { // Loop through found vehicles
                // Print details for each vehicle
                System.out.println(vehicle.getVin() + ": " + vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
            }
        }
    }

    // Method to find vehicles by make/model
    private void findVehiclesByMakeModel() {
        System.out.print("Enter make: "); // Ask for make
        String make = scanner.next(); // Read make
        System.out.print("Enter model: "); // Ask for model
        String model = scanner.next(); // Read model

        List<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model); // Find vehicles
        if (vehiclesByMakeModel.isEmpty()) {
            System.out.println("No vehicles found with this make/model."); // Inform user
        } else {
            System.out.println("Vehicles found:"); // Header for results
            for (Vehicle vehicle : vehiclesByMakeModel) { // Loop through found vehicles
                // Print details for each vehicle
                System.out.println(vehicle.getVin() + ": " + vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
            }
        }
    }

    // Method to find vehicles by year range
    private void findVehiclesByYear() {
        System.out.print("Enter minimum year: "); // Ask for minimum year
        int minYear = scanner.nextInt(); // Read minimum year
        System.out.print("Enter maximum year: "); // Ask for maximum year
        int maxYear = scanner.nextInt(); // Read maximum year

        List<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(minYear, maxYear); // Find vehicles
        if (vehiclesByYear.isEmpty()) {
            System.out.println("No vehicles found in this year range."); // Inform user
        } else {
            System.out.println("Vehicles found:"); // Header for results
            for (Vehicle vehicle : vehiclesByYear) { // Loop through found vehicles
                // Print details for each vehicle
                System.out.println(vehicle.getVin() + ": " + vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
            }
        }
    }

    // Method to find vehicles by color
    private void findVehiclesByColor() {
        System.out.print("Enter color: "); // Ask for color
        String color = scanner.next(); // Read color

        List<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color); // Find vehicles
        if (vehiclesByColor.isEmpty()) {
            System.out.println("No vehicles found with this color."); // Inform user
        } else {
            System.out.println("Vehicles found:"); // Header for results
            for (Vehicle vehicle : vehiclesByColor) { // Loop through found vehicles
                // Print details for each vehicle
                System.out.println(vehicle.getVin() + ": " + vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
            }
        }
    }

    // New method to sell or lease a vehicle
    private void sellOrLeaseVehicle() {
        System.out.print("Enter VIN of the vehicle to sell/lease: "); // Ask for VIN
        int vin = scanner.nextInt(); // Read VIN
        Vehicle vehicle = dealership.getVehicleByVin(vin); // Find vehicle by VIN

        if (vehicle == null) {
            System.out.println("Vehicle not found!"); // If vehicle doesn't exist
            return; // Exit the method
        }

        System.out.print("Enter 'sell' to sell or 'lease' to lease: "); // Ask user for action
        String action = scanner.next().toLowerCase(); // Read action and convert to lowercase

        if (action.equals("sell")) {
            dealership.sellVehicle(vehicle); // Call method to sell vehicle
            System.out.println("Vehicle sold successfully!"); // Confirmation message
        } else if (action.equals("lease")) {
            dealership.leaseVehicle(vehicle); // Call method to lease vehicle
            System.out.println("Vehicle leased successfully!"); // Confirmation message
        } else {
            System.out.println("Invalid action! Please enter 'sell' or 'lease'."); // Inform user about invalid input
        }
    }
}
