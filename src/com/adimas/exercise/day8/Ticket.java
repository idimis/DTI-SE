package com.adimas.exercise.day8;

// Interface for the Ticketable contract
interface Ticketable {
}

// Ticket class as a blueprint for creating ticket objects
class Ticket implements Ticketable {

    // Static field to track the total number of tickets sold
    private static int totalTicketsSold = 0;

    // Private fields for ticket details, encapsulated to protect the data
    private final int id;
    private final String name;
    private boolean isBooked;
    private boolean isValidated;
    private boolean isConfirmed;

    // Constructor to initialize ticket objects
    public Ticket(int id, String name) {
        this.id = id;
        this.name = name;
        this.isBooked = false;
        this.isValidated = false;
        this.isConfirmed = false;
    }

    // Public getter methods to access private fields
    public int getId() {
        return id;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    // Method to book a ticket, which also increments the static ticket count
    public void book() {
        if (!this.isBooked) {
            this.isBooked = true;
            totalTicketsSold++; // Increment when a ticket is booked
        }
    }

    // Method to validate a ticket
    public void validate() {
        this.isValidated = true;
    }

    // Method to confirm a ticket
    public void confirm() {
        this.isConfirmed = true;
    }

    // Implementing the method from Ticketable interface to print ticket details
    public void printTicketDetails() {
        System.out.println("Ticket ID: " + id + ", Name: " + name +
                ", Booked: " + isBooked + ", Validated: " + isValidated +
                ", Confirmed: " + isConfirmed);
    }

    // Overriding the toString method for easy display of ticket details
    @Override
    public String toString() {
        return "Ticket ID: " + id + ", Name: " + name +
                ", Booked: " + isBooked + ", Validated: " + isValidated +
                ", Confirmed: " + isConfirmed;
    }
}

