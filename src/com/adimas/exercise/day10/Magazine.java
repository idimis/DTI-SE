package com.adimas.exercise.day10;

public class Magazine extends LibraryMaterial {
    private int issueNumber;

    // Constructor for magazine, includes issue number
    public Magazine(String title, String author, int availableCount, int issueNumber) {
        super(title, author, availableCount);
        this.issueNumber = issueNumber;
    }

    // Print the status of the magazine, including issue number
    @Override
    public void printStatus() {
        System.out.println("Magazine Title: " + title + " | Issue Number: " + issueNumber + " | Available: " + availableCount);

    }
}
