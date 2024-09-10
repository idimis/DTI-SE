package com.adimas.exercise.day7;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise7 {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Calculate average of numbers");
            System.out.println("2. Process CSV file");
            System.out.println("3. Exit");

            // Read the user input
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character left by nextInt()

                switch (choice) {
                    case 1:
                        runAverageCalculator();
                        break;
                    case 2:
                        runCSVReader();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return; // Exit the method and terminate the program
                    default:
                        System.out.println("Invalid choice. Please select 1, 2, or 3.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    // Task 1: Calculate average of numbers entered by the user
    public static void runAverageCalculator() {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int count = 0;

        System.out.println("Enter numbers to calculate average. Type 'q' to finish.");

        while (true) {
            String input = scanner.nextLine();

            // Check if the user wants to quit
            if (input.equalsIgnoreCase("q")) {
                break;
            }

            try {
                // Try to parse the input as a double
                double number = Double.parseDouble(input);
                sum += number;
                count++;
            } catch (NumberFormatException e) {
                // If input is not a valid number, print an error message
                System.out.println("Invalid input. Please enter a valid number or 'q' to finish.");
            }
        }

        // Calculate and print the average if count is greater than 0
        if (count > 0) {
            double average = sum / count;
            System.out.printf("Average: %.2f%n", average);
        } else {
            System.out.println("No valid numbers entered.");
        }
    }

    // Task 2: Process CSV file and calculate product summary
    public static void runCSVReader() {
        // Define the path to the CSV file
        String csvFilePath = "res/product_sales_data.csv";

        double totalSales = 0;
        int totalProductSold = 0;
        int maxQuantity = Integer.MIN_VALUE;
        int minQuantity = Integer.MAX_VALUE;
        String mostBoughtProduct = "";
        String leastBoughtProduct = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            // Read the header line (skip it)
            String headerLine = br.readLine();
            if (headerLine != null) {
                // Process each line of the file
                while ((line = br.readLine()) != null) {
                    // Split the line by comma
                    String[] values = line.split(",");

                    if (values.length == 3) {
                        // Extract data from the split values
                        String productName = values[0].trim();
                        int quantitySold = Integer.parseInt(values[1].trim());
                        double salesAmount = Double.parseDouble(values[2].trim());

                        // Update totals
                        totalSales += salesAmount;
                        totalProductSold += quantitySold;

                        // Determine the most and least bought products
                        if (quantitySold > maxQuantity) {
                            maxQuantity = quantitySold;
                            mostBoughtProduct = productName;
                        }
                        if (quantitySold < minQuantity) {
                            minQuantity = quantitySold;
                            leastBoughtProduct = productName;
                        }
                    } else {
                        System.err.println("Invalid line format: " + line);
                    }
                }
            }

            // Print the summary
            System.out.printf("Total Sales: %.2f%n", totalSales);
            System.out.printf("Total Product Sold: %d%n", totalProductSold);
            System.out.printf("Most Bought Product: %s%n", mostBoughtProduct);
            System.out.printf("Least Bought Product: %s%n", leastBoughtProduct);

        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
    }
}
