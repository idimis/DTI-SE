package com.adimas.exercise.day11;

import java.util.Scanner;

public class Exercise11 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("Select an exercise to run:");
            System.out.println("1. Stack");
            System.out.println("2. Queue");
            System.out.println("3. Binary Search Tree");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    runStackOperations(scanner);
                    break;
                case 2:
                    runQueueOperations(scanner);
                    break;
                case 3:
                    runBinarySearchTreeOperations(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void runStackOperations(Scanner scanner) {
        Stack stack = new Stack();
        System.out.println("Stack Operations:");

        // Push elements to stack
        System.out.println("Push elements to stack (enter 0 to stop):");
        while (true) {
            int input = scanner.nextInt();
            if (input == 0) break;
            stack.push(input);
        }

        // Peek top element
        if (stack.head != null) {
            System.out.println("Peek top of stack: " + stack.peek());
        } else {
            System.out.println("Stack is empty.");
        }

        // Pop elements from stack
        System.out.println("Popping elements from stack:");
        while (stack.head != null) {
            System.out.println("Popped: " + stack.pop());
        }
    }

    private static void runQueueOperations(Scanner scanner) {
        Queue queue = new Queue();
        System.out.println("Queue Operations:");

        // Enqueue elements to queue
        System.out.println("Enqueue elements to queue (enter 0 to stop):");
        while (true) {
            int input = scanner.nextInt();
            if (input == 0) break;
            queue.enqueue(input);
        }

        // Peek front element
        if (queue.head != null) {
            System.out.println("Peek front of queue: " + queue.peek());
        } else {
            System.out.println("Queue is empty.");
        }

        // Dequeue elements from queue
        System.out.println("Dequeuing elements from queue:");
        while (queue.head != null) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }

    private static void runBinarySearchTreeOperations(Scanner scanner) {
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("Binary Search Tree Operations:");

        // Insert elements into BST
        System.out.print("Enter number of elements to insert into BST: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            bst.insert(scanner.nextInt());
        }

        // Search elements in BST
        while (true) {
            System.out.print("Enter number to search in BST (or -1 to exit): ");
            int number = scanner.nextInt();
            if (number == -1) break;
            if (bst.search(number)) {
                System.out.println("Number " + number + " found in the BST.");
            } else {
                System.out.println("Number " + number + " not found in the BST.");
            }
        }
    }
}
