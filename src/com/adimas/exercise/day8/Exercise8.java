package com.adimas.exercise.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise8 {
    private List<Ticket> tickets;
    private Scanner scanner;

    public Exercise8() {
        tickets = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void runTicketCreation() {
        System.out.print("Enter ticket ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter ticket name: ");
        String name = scanner.nextLine();

        Ticket ticket = new Ticket(id, name);
        tickets.add(ticket);

        System.out.println("Ticket created successfully: " + ticket);
    }

    public void runTicketBooking() {
        System.out.print("Enter ticket ID to book: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Ticket ticket = findTicketById(id);
        if (ticket != null && !ticket.isBooked()) {
            ticket.book();
            System.out.println("Ticket booked successfully: " + ticket);
        } else {
            System.out.println("Ticket not found or already booked.");
        }
    }

    public void runTicketValidation() {
        System.out.print("Enter ticket ID to validate: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Ticket ticket = findTicketById(id);
        if (ticket != null && ticket.isBooked() && !ticket.isValidated()) {
            ticket.validate();
            System.out.println("Ticket validated successfully: " + ticket);
        } else {
            System.out.println("Ticket not found, not booked, or already validated.");
        }
    }

    public void runTicketConfirmation() {
        System.out.print("Enter ticket ID to confirm: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Ticket ticket = findTicketById(id);
        if (ticket != null && ticket.isBooked() && ticket.isValidated() && !ticket.isConfirmed()) {
            ticket.confirm();
            System.out.println("Ticket confirmed successfully: " + ticket);
        } else {
            System.out.println("Ticket not found, not validated, or already confirmed.");
        }
    }

    private Ticket findTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    // Main method to run the program
    public static void run() {
        Exercise8 system = new Exercise8();

        int choice = -1;

        while (choice != 0) {
            System.out.println("Welcome to the Ticketing System");
            System.out.println("1. Create a Ticket");
            System.out.println("2. Book a Ticket");
            System.out.println("3. Validate a Ticket");
            System.out.println("4. Confirm a Ticket");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = system.scanner.nextInt();
            system.scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    system.runTicketCreation();
                    break;
                case 2:
                    system.runTicketBooking();
                    break;
                case 3:
                    system.runTicketValidation();
                    break;
                case 4:
                    system.runTicketConfirmation();
                    break;
                case 0:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        system.scanner.close(); // Close scanner when done
    }

    public static void main(String[] args) {
        run();
    }
}
