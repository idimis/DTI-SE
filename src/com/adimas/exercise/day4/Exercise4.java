package com.adimas.exercise.day4;

import java.util.Scanner;
import java.util.Random;

public class Exercise4 {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        Exercise4 tasks = new Exercise4();

        // Input integer to select which method to run
        while (true) {
            System.out.println("\nChoose the task you want to execute:");
            System.out.println("1. Print Multiplication Table");
            System.out.println("2. Print Pattern of Stars");
            System.out.println("3. Read n Inputs from Scanner");
            System.out.println("4. Play Number Guessing Game");
            System.out.println("5. Swap Case of Each Character");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear buffer after integer input

            switch (choice) {
                case 1:
                    tasks.printMultiplicationTable();
                    break;
                case 2:
                    tasks.printPattern();
                    break;
                case 3:
                    tasks.readNInputs();
                    break;
                case 4:
                    tasks.numberGuessingGame();
                    break;
                case 5:
                    tasks.swapCase();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method 1: Print multiplication table up to n x n
    public void printMultiplicationTable() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of n for the multiplication table: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println(); // Move to next line after each row
        }
    }

    // Method 2: Print pattern of stars for n rows
    public void printPattern() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows for the pattern: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to next line after each row
        }
    }

    // Method 3: Read n inputs from the scanner, stopping based on user input
    public void readNInputs() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        int count = 0;

        do {
            System.out.println("Enter a number: ");
            int num = scanner.nextInt();
            System.out.println("You entered: " + num);
            count++;
            System.out.println("Press 'y' to continue or 'n' to stop.");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("y"));

        System.out.println("You entered " + count + " numbers.");
    }

    // Method 4: Number guessing game
    public void numberGuessingGame() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
        int guess;
        int attempts = 0;

        System.out.println("Guess a number between 1 and 100:");

        while (true) {
            guess = scanner.nextInt();
            attempts++;

            if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                break;
            }
        }
    }

    // Method 5: Swap case of each character in the string
    public void swapCase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String input = scanner.nextLine();
        StringBuilder swappedString = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                swappedString.append(Character.toLowerCase(c));
            } else {
                swappedString.append(Character.toUpperCase(c));
            }
        }

        System.out.println("Swapped case result: " + swappedString);
    }
}
