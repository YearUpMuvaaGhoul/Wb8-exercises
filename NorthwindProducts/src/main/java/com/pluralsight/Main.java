package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        if (args.length != 2) {
            System.out.println(
                    "Application needs two arguments to run: " +
                            "java com.pluralsight.wb8demo2 <username> <password>");
            System.exit(1);
        }

        // get the user name and password from the command line args
        String username = args[0];
        String password = args[1];

        try {

            // load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. open a connection to the database
            // use the database URL to point to the correct database
            Connection connection;

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", username, password);

            PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM northwind.products");

            ResultSet results = pStatement.executeQuery();
            // process the results
            // process the results
            while (results.next()) {
                String city = results.getString("productname");
                int productid = result;
                System.out.println(productid);
            }
//Modify your code to display all Products in the Northwind database. The list 
//must include:
//- product id
//- product name
//- unit price
//- units in stock
            
            // 3. Close the connection
            results.close();
            pStatement.close();
            connection.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println("There was an issue finding a class:");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("There was an SQL issue:");
            e.printStackTrace();
        }
    }
}


