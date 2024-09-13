package com.adimas.exercise.day10;

public abstract class LibraryMaterial {
    protected String title;
    protected String author;
    protected int availableCount;

    // Constructor for all library materials
    public LibraryMaterial(String title, String author, int availableCount) {
        this.title = title;
        this.author = author;
        this.availableCount = availableCount;
    }

    // Borrowing method to reduce availability
    public void borrowMaterial() {
        if (availableCount > 0) {
            availableCount--;
            System.out.println("Borrowed: " + title);
        } else {
            System.out.println(title + " is not available for borrowing.");
        }
    }

    // Returning method to increase availability
    public void returnMaterial() {
        availableCount++;
        System.out.println("Returned: " + title);
    }

    // Abstract method to be overridden in subclasses for displaying the status
    public abstract void printStatus();
}
