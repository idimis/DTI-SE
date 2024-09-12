package com.adimas.exercise.day9;

import java.util.*;

public class Exercise9 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, List<Task>> tasks = new HashMap<>();

    public static void run() {
        while (true) {
            System.out.println("\n--- To-Do List App ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerUser();
                    break;
                case "2":
                    loginUser();
                    break;
                case "3":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void registerUser() {
        System.out.print("Enter your desired login: ");
        String login = scanner.nextLine();
        if (users.containsKey(login)) {
            System.out.println("Login already exists. Try a different one.");
            return;
        }
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        users.put(login, password);
        System.out.println("Account created successfully!");
    }

    private static void loginUser() {
        System.out.print("Enter your login: ");
        String login = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        if (users.containsKey(login) && users.get(login).equals(password)) {
            System.out.println("Login successful!");
            mainMenu(login);
        } else {
            System.out.println("Invalid login or password.");
        }
    }

    private static void mainMenu(String loggedInUser) {
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Logout");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTask(loggedInUser);
                    break;
                case "2":
                    viewTasks(loggedInUser);
                    break;
                case "3":
                    deleteTask(loggedInUser);
                    break;
                case "4":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void addTask(String userLogin) {
        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();
        Task task = new Task(UUID.randomUUID().toString(), description);
        tasks.computeIfAbsent(userLogin, k -> new ArrayList<>()).add(task);
        System.out.println("Task added successfully!");
    }

    private static void viewTasks(String userLogin) {
        List<Task> userTasks = tasks.get(userLogin);
        if (userTasks != null && !userTasks.isEmpty()) {
            System.out.println("\n--- Your Tasks ---");
            for (int i = 0; i < userTasks.size(); i++) {
                Task task = userTasks.get(i);
                System.out.println((i + 1) + ". " + task.getDescription());
            }
        } else {
            System.out.println("No tasks found.");
        }
    }

    private static void deleteTask(String userLogin) {
        viewTasks(userLogin);
        System.out.print("Enter the task number to delete: ");
        int taskIndex = Integer.parseInt(scanner.nextLine()) - 1;
        List<Task> userTasks = tasks.get(userLogin);
        if (userTasks != null && taskIndex >= 0 && taskIndex < userTasks.size()) {
            Task removedTask = userTasks.remove(taskIndex);
            System.out.println("Task '" + removedTask.getDescription() + "' deleted successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static class Task {
        private final String id;
        private final String description;

        public Task(String id, String description) {
            this.id = id;
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }
    }
}