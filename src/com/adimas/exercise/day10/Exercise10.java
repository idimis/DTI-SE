package com.adimas.exercise.day10;

import java.util.Scanner;

public class Exercise10 {

    private static Book[] books = {
            new Book("1984", "George Orwell", 3, "Dystopian"),
            new Book("Anna Karenina", "Leo Tolstoy", 5, "Classic Drama"),
            new Book("Metamorphosis", "Franz Kafka", 4, "Surrealism")
    };

    private static Magazine[] magazines = {
            new Magazine("National Geographic", "Various", 5, 202),
            new Magazine("Kinfolk", "Various", 7, 325),
            new Magazine("Forbes", "Various", 3, 118)
    };

    private static DVD[] dvds = {
            new DVD("Inception", "Christopher Nolan", 2),
            new DVD("My Neighbor Totoro", "Hayao Miyazaki", 4),
            new DVD("Chungking Express", "Wong Kar Wai", 3)
    };

    private static void checkAvailability() {
        System.out.println("\n--- Availability Status ---");
        for (Book book : books) {
            book.printStatus();
        }
        for (Magazine magazine : magazines) {
            magazine.printStatus();
        }
        for (DVD dvd : dvds) {
            dvd.printStatus();
        }
    }

    private static void addNewMaterial(Scanner scanner) {
        System.out.println("\n--- Add New Material ---");
        System.out.println("1. Add Book");
        System.out.println("2. Add Magazine");
        System.out.println("3. Add DVD");
        System.out.print("Enter your choice: ");
        int addChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (addChoice) {
            case 1:
                System.out.print("Enter Book Title: ");
                String bookTitle = scanner.nextLine();
                System.out.print("Enter Book Author: ");
                String bookAuthor = scanner.nextLine();
                System.out.print("Enter Number of Copies: ");
                int bookCopies = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter Book Genre: ");
                String bookGenre = scanner.nextLine();
                Book newBook = new Book(bookTitle, bookAuthor, bookCopies, bookGenre);
                addBook(newBook);
                break;
            case 2:
                System.out.print("Enter Magazine Title: ");
                String magTitle = scanner.nextLine();
                System.out.print("Enter Magazine Publisher: ");
                String magPublisher = scanner.nextLine();
                System.out.print("Enter Number of Copies: ");
                int magCopies = scanner.nextInt();
                System.out.print("Enter Issue Number: ");
                int magIssue = scanner.nextInt();
                Magazine newMagazine = new Magazine(magTitle, magPublisher, magCopies, magIssue);
                addMagazine(newMagazine);
                break;
            case 3:
                System.out.print("Enter DVD Title: ");
                String dvdTitle = scanner.nextLine();
                System.out.print("Enter DVD Director: ");
                String dvdDirector = scanner.nextLine();
                System.out.print("Enter Number of Copies: ");
                int dvdCopies = scanner.nextInt();
                DVD newDVD = new DVD(dvdTitle, dvdDirector, dvdCopies);
                addDVD(newDVD);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void addBook(Book book) {
        // Add book to the library (For simplicity, we'll just print a message)
        System.out.println("Added new book: " + book.title);
    }

    private static void addMagazine(Magazine magazine) {
        // Add magazine to the library (For simplicity, we'll just print a message)
        System.out.println("Added new magazine: " + magazine.title);
    }

    private static void addDVD(DVD dvd) {
        // Add DVD to the library (For simplicity, we'll just print a message)
        System.out.println("Added new DVD: " + dvd.title);
    }

    private static void manageUsers(Scanner scanner) {
        System.out.println("\n--- User Management ---");
        System.out.println("1. Add User");
        System.out.println("2. Remove User");
        System.out.println("3. List Users");
        System.out.print("Enter your choice: ");
        int userChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (userChoice) {
            case 1:
                System.out.print("Enter User Name: ");
                String newUserName = scanner.nextLine();
                // Add user to the system (For simplicity, we'll just print a message)
                System.out.println("Added new user: " + newUserName);
                break;
            case 2:
                System.out.print("Enter User Name to Remove: ");
                String removeUserName = scanner.nextLine();
                // Remove user from the system (For simplicity, we'll just print a message)
                System.out.println("Removed user: " + removeUserName);
                break;
            case 3:
                // List users (For simplicity, we'll just print a message)
                System.out.println("Listing users...");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void run() {
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            // Display menu options
            System.out.println("\n--- Shakespeare & Chairil. Co ---");
            System.out.println("1. View material status");
            System.out.println("2. Borrow material");
            System.out.println("3. Return material");
            System.out.println("4. Check availability");
            System.out.println("5. Add new material");
            System.out.println("6. Manage users");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            // Read user choice
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // View all materials' status
                    System.out.println("\n--- Material Status ---");
                    for (Book book : books) {
                        book.printStatus();
                    }
                    for (Magazine magazine : magazines) {
                        magazine.printStatus();
                    }
                    for (DVD dvd : dvds) {
                        dvd.printStatus();
                    }
                    break;

                case 2:
                    // Borrow material
                    System.out.println("\n--- Borrow Material ---");
                    System.out.println("1. Borrow Book");
                    System.out.println("2. Borrow Magazine");
                    System.out.println("3. Borrow DVD");
                    System.out.print("Enter your choice: ");
                    int borrowChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    switch (borrowChoice) {
                        case 1:
                            System.out.println("Select Book to Borrow: ");
                            for (int i = 0; i < books.length; i++) {
                                System.out.println((i + 1) + ". " + books[i].title);
                            }
                            int bookBorrowIndex = scanner.nextInt() - 1;
                            if (bookBorrowIndex >= 0 && bookBorrowIndex < books.length) {
                                books[bookBorrowIndex].borrowMaterial();
                            } else {
                                System.out.println("Invalid choice.");
                            }
                            break;
                        case 2:
                            System.out.println("Select Magazine to Borrow: ");
                            for (int i = 0; i < magazines.length; i++) {
                                System.out.println((i + 1) + ". " + magazines[i].title);
                            }
                            int magBorrowIndex = scanner.nextInt() - 1;
                            if (magBorrowIndex >= 0 && magBorrowIndex < magazines.length) {
                                magazines[magBorrowIndex].borrowMaterial();
                            } else {
                                System.out.println("Invalid choice.");
                            }
                            break;
                        case 3:
                            System.out.println("Select DVD to Borrow: ");
                            for (int i = 0; i < dvds.length; i++) {
                                System.out.println((i + 1) + ". " + dvds[i].title);
                            }
                            int dvdBorrowIndex = scanner.nextInt() - 1;
                            if (dvdBorrowIndex >= 0 && dvdBorrowIndex < dvds.length) {
                                dvds[dvdBorrowIndex].borrowMaterial();
                            } else {
                                System.out.println("Invalid choice.");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;

                case 3:
                    // Return material
                    System.out.println("\n--- Return Material ---");
                    System.out.println("1. Return Book");
                    System.out.println("2. Return Magazine");
                    System.out.println("3. Return DVD");
                    System.out.print("Enter your choice: ");
                    int returnChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    switch (returnChoice) {
                        case 1:
                            System.out.println("Select Book to Return: ");
                            for (int i = 0; i < books.length; i++) {
                                System.out.println((i + 1) + ". " + books[i].title);
                            }
                            int bookReturnIndex = scanner.nextInt() - 1;
                            if (bookReturnIndex >= 0 && bookReturnIndex < books.length) {
                                books[bookReturnIndex].returnMaterial();
                            } else {
                                System.out.println("Invalid choice.");
                            }
                            break;
                        case 2:
                            System.out.println("Select Magazine to Return: ");
                            for (int i = 0; i < magazines.length; i++) {
                                System.out.println((i + 1) + ". " + magazines[i].title);
                            }
                            int magReturnIndex = scanner.nextInt() - 1;
                            if (magReturnIndex >= 0 && magReturnIndex < magazines.length) {
                                magazines[magReturnIndex].returnMaterial();
                            } else {
                                System.out.println("Invalid choice.");
                            }
                            break;
                        case 3:
                            System.out.println("Select DVD to Return: ");
                            for (int i = 0; i < dvds.length; i++) {
                                System.out.println((i + 1) + ". " + dvds[i].title);
                            }
                            int dvdReturnIndex = scanner.nextInt() - 1;
                            if (dvdReturnIndex >= 0 && dvdReturnIndex < dvds.length) {
                                dvds[dvdReturnIndex].returnMaterial();
                            } else {
                                System.out.println("Invalid choice.");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;

                case 4:
                    // Check availability
                    checkAvailability();
                    break;

                case 5:
                    // Add new material
                    addNewMaterial(scanner);
                    break;

                case 6:
                    // Manage users
                    manageUsers(scanner);
                    break;

                case 7:
                    // Exit the program
                    exit = true;
                    System.out.println("Exiting Library Management System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
