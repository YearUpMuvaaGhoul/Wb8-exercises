package com.pluralsight.Contracts;


import java.io.BufferedReader; // Import BufferedReader for reading files
import java.io.FileReader; // Import FileReader for reading files
import java.io.FileWriter; // Import FileWriter for writing files
import java.io.IOException; // Import IOException for handling errors
import java.util.ArrayList; // Import ArrayList for managing collections
import java.util.List; // Import List interface

// Class to manage contract records
public class ContractFileManager {
    private String filename; // Holds the name of the contracts file

    // Constructor to initialize the filename
    public ContractFileManager(String filename) {
        this.filename = filename; // Set the filename using the parameter
    }

    // Method to load all contracts from the CSV file
    public List<String> loadContracts() {
        List<String> contracts = new ArrayList<>(); // List to hold contract records

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) { // Create a BufferedReader to read the file
            String line; // Variable to hold each line read from the file

            // Read each line from the contracts CSV
            while ((line = reader.readLine()) != null) { // Continue reading lines until there are none left
                contracts.add(line); // Add the line to the contracts list
            }
        } catch (IOException e) { // Handle any IO exceptions
            System.out.println("Error loading contracts: " + e.getMessage()); // Print error message
        }
        return contracts; // Return the list of contracts
    }

    // Method to append a new contract record to the contracts CSV file
    public void appendToContractsFile(String record) {
        try (FileWriter writer = new FileWriter(filename, true)) { // Open the contracts file in append mode
            writer.write(record + "\n"); // Write the record followed by a new line
        } catch (IOException e) { // Handle any file writing errors
            System.out.println("Error writing to contracts file: " + e.getMessage()); // Print error message
        }
    }
}