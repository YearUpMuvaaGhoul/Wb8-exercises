package com.pluralsight.Contracts;


// This is an abstract class representing a generic contract
public abstract class Contract {
    // Private variables to hold common attributes of a contract
    private String date;            // The date of the contract
    private String customerName;    // The name of the customer
    private String customerEmail;   // The email of the customer
    private String vehicleSold;      // The vehicle that was sold (could be a VIN or description)

    // Constructor to initialize the contract with common attributes
    public Contract(String date, String customerName, String customerEmail, String vehicleSold) {
        this.date = date;                 // Set the contract date
        this.customerName = customerName; // Set the customer's name
        this.customerEmail = customerEmail; // Set the customer's email
        this.vehicleSold = this.vehicleSold;   // Set the sold vehicle information
    }

    public Contract(String date, String customerName, String customerEmail) {

    }

    // Getter for the contract date
    public String getDate() {
        return date; // Return the date of the contract
    }

    // Getter for the customer's name
    public String getCustomerName() {
        return customerName; // Return the customer's name
    }

    // Getter for the customer's email
    public String getCustomerEmail() {
        return customerEmail; // Return the customer's email
    }

    // Getter for the sold vehicle information
    public String getVehicleSold() {
        return vehicleSold; // Return information about the sold vehicle
    }

    // Setter for the contract date
    public void setDate(String date) {
        this.date = date; // Update the contract date
    }

    // Setter for the customer's name
    public void setCustomerName(String customerName) {
        this.customerName = customerName; // Update the customer's name
    }

    // Setter for the customer's email
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail; // Update the customer's email
    }

    // Setter for the sold vehicle information
    public void setVehicleSold(String vehicleSold) {
        this.vehicleSold = vehicleSold; // Update information about the sold vehicle
    }

    // Abstract method to compute and return the total price of the contract
    public abstract double getTotalPrice(); // To be implemented by subclasses

    // Abstract method to compute and return the monthly payment for the contract
    public abstract double getMonthlyPayment(); // To be implemented by subclasses
}
