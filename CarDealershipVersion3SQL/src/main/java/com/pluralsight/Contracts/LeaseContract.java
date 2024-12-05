package com.pluralsight.Contracts;


public class LeaseContract extends Contract {
    private double leasePrice;       // Total lease price of the vehicle
    private int leaseTerm;           // Lease term in months
    private double expectedEndingValue; // Expected ending value after lease

    // Constructor to initialize the LeaseContract
    public LeaseContract(String date, String customerName, String customerEmail, double leasePrice, int leaseTerm) {
        super(date, customerName, customerEmail);
        this.leasePrice = leasePrice; // Set the lease price
        this.leaseTerm = leaseTerm;    // Set the lease term
        this.expectedEndingValue = leasePrice * 0.50; // Expected ending value is 50% of original price
        setVehicleSold("Vehicle leased under lease contract");
    }

    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {
        double leaseFee = leasePrice * 0.07; // 7% lease fee
        return (leasePrice + leaseFee) * leaseTerm; // Total price includes lease payments over the term
    }

    @Override
    public double getMonthlyPayment() {
        // Calculate the monthly payment based on the total lease cost
        double totalLeaseCost = getTotalPrice(); // Total cost including fees
        return totalLeaseCost / leaseTerm; // Monthly payment is the total lease cost divided by lease term
    }
}