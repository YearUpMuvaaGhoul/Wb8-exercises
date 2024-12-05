package com.pluralsight.Contracts;

public class SaleContract extends Contract {
    private double salePrice;      // Total sale price of the vehicle
    private double downPayment;     // Down payment made by the customer
    private boolean isFinanced;     // Whether the vehicle is financed or not

    // Constructor to initialize the SalesContract
    public SaleContract(String date, String customerName, String customerEmail, double salePrice, double downPayment, boolean isFinanced) {
        super(date, customerName, customerEmail);
        this.salePrice = salePrice; // Set the sale price
        this.downPayment = downPayment; // Set the down payment
        this.isFinanced = isFinanced; // Set financing option
        setVehicleSold("Vehicle sold under sales contract");
    }

    @Override
    public double getTotalPrice() {
        double salesTax = salePrice * 0.05; // 5% sales tax
        double recordingFee = 100.0;         // Fixed recording fee
        double processingFee;

        // Determine processing fee based on sale price
        if (salePrice < 10000) {
            processingFee = 295.0; // Processing fee for vehicles under $10,000
        } else {
            processingFee = 495.0; // Processing fee for vehicles $10,000 or more
        }

        // Total price calculation
        return salePrice + salesTax + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) {
            return 0; // No monthly payment if not financed
        }

        double loanAmount = getTotalPrice() - downPayment; // Amount to be financed
        double interestRate;
        int termMonths;

        // Determine interest rate and term based on sale price
        if (salePrice >= 10000) {
            interestRate = 0.0425; // 4.25% interest for vehicles $10,000 or more
            termMonths = 48;       // 48-month term
        } else {
            interestRate = 0.0525; // 5.25% interest for vehicles under $10,000
            termMonths = 24;       // 24-month term
        }

        // Monthly payment calculation using the formula for an amortizing loan
        return (loanAmount * interestRate / 12) / (1 - Math.pow(1 + interestRate / 12, -termMonths));
    }
}