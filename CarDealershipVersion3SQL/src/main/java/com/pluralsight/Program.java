package com.pluralsight;



public class Program {
    public static void main(String[] args) {
        // Create a new dealership instance
        Dealership dealership = new Dealership("Best Cars", "123 Main St", "555-1234");

        // Create the user interface and start it
        UserInterface userInterface = new UserInterface(dealership);
        userInterface.start(); // Start the user interface
    }
}