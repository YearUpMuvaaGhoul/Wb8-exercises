package com.pluralsight;


// Class to represent a specific vehicle
public class Vehicle {
    // Private variables to hold vehicle information
    private int vin; // Vehicle ID Number
    private int year; // Year the vehicle was manufactured
    private String make; // Manufacturer of the vehicle Ford
    private String model; // Model of the vehicle
    private String vehicleType; // Type of the vehicle
    private String color; // Color of the vehicle
    private int odometer; // Mileage of the vehicle
    private double price; // Price of the vehicle

    // Constructor to initialize a Vehicle object with provided values
    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin; // Set the VIN
        this.year = year; // Set the manufacturing year
        this.make = make; // Set the make of the vehicle
        this.model = model; // Set the model of the vehicle
        this.vehicleType = vehicleType; // Set the type of the vehicle
        this.color = color; // Set the color of the vehicle
        this.odometer = odometer; // Set the odometer reading
        this.price = price; // Set the price of the vehicle
    }

    // Getter method for VIN
    public int getVin() {
        return vin; // Return the VIN
    }

    // Getter method for year
    public int getYear() {
        return year; // Return the manufacturing year
    }

    // Getter method for make
    public String getMake() {
        return make; // Return the make of the vehicle
    }

    // Getter method for model
    public String getModel() {
        return model; // Return the model of the vehicle
    }

    // Getter method for vehicle type
    public String getVehicleType() {
        return vehicleType; // Return the type of the vehicle
    }

    // Getter method for color
    public String getColor() {
        return color; // Return the color of the vehicle
    }

    // Getter method for odometer reading
    public int getOdometer() {
        return odometer; // Return the odometer reading
    }

    // Getter method for price
    public double getPrice() {
        return price; // Return the price of the vehicle
    }
}

