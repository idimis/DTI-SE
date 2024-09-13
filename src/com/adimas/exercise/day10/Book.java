package com.adimas.exercise.day10;

public class Book extends LibraryMaterial {
    private String genre;

    // Constructor for book, includes genre
    public Book(String title, String author, int availableCount, String genre) {
        super(title, author, availableCount);
        this.genre = genre;
    }

    // Print the status of the book, including genre
    @Override
    public void printStatus() {
        System.out.println("Book Title: " + title + " | Author: " + author + " | Available: " + availableCount + " | Genre: " + genre);
    }
}

