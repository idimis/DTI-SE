package com.adimas.exercise.day10;

public class DVD extends LibraryMaterial {
    private String director;

    // Constructor for DVD, includes director
    public DVD(String title, String director, int availableCount) {
        super(title, director, availableCount);
        this.director = director;
    }

    // Print the status of the DVD, including director's name
    @Override
    public void printStatus() {
        System.out.println("DVD Title: " + title + " | Director: " + director + " | Available: " + availableCount);
    }
}

