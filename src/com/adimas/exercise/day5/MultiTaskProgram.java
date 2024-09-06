package com.adimas.exercise.day5;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

public class MultiTaskProgram {


    // Task 1: Word Guessing Game
    private static final String[] WORDS = {"apple", "banana", "cherry", "date", "fig"};

    // Method to select a random word from the array
    public static String selectRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }

    // Method to return a hidden version of the word (e.g. "____")
    public static String hideWord(String word) {
        return "_".repeat(word.length());
    }

    // Method to get the player's guess
    public static char getPlayerGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess a letter: ");
        return scanner.next().charAt(0);
    }

    // Method to check if the guess is correct
    public static boolean isGuessCorrect(String word, char guess) {
        return word.indexOf(guess) >= 0;
    }

    // Method to update the hidden word by revealing the correct guess
    public static String updateHiddenWord(String word, String hiddenWord, char guess) {
        StringBuilder updatedWord = new StringBuilder(hiddenWord);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                updatedWord.setCharAt(i, guess);
            }
        }
        return updatedWord.toString();
    }

    // Method to display the game result
    public static void displayGameResult(String wordToGuess, String hiddenWord) {
        if (hiddenWord.equals(wordToGuess)) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Out of attempts! The word was: " + wordToGuess);
        }
    }

    // Task 2: Currency Converter
    private static final double USD_TO_EUR = 0.92;
    private static final double EUR_TO_USD = 1.08;
    private static final double USD_TO_GBP = 0.79;
    private static final double USD_TO_JPY = 147.65;

    // Method to convert currency based on input
    public static double convertCurrency(double amount, String from, String to) {
        if (from.equals("USD") && to.equals("EUR")) return amount * USD_TO_EUR;
        if (from.equals("EUR") && to.equals("USD")) return amount * EUR_TO_USD;
        if (from.equals("USD") && to.equals("GBP")) return amount * USD_TO_GBP;
        if (from.equals("USD") && to.equals("JPY")) return amount * USD_TO_JPY;
        return amount; // If no conversion is needed
    }

    // Task 3: Remove Odd Numbers from Array
    public static int[] removeOddNumbers(int[] nums) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }
        return evenNumbers.stream().mapToInt(i -> i).toArray();
    }

    // Task 4: FizzBuzz
    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Task 5: Two Sum Problem
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null; // Return null if no pair exists
    }

    // Main method to demonstrate all tasks
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        // Task 1: Word Guessing Game
        System.out.println("=== Task 1: Word Guessing Game ===");
        String wordToGuess = selectRandomWord();
        String hiddenWord = hideWord(wordToGuess);
        int attemptsLeft = 6;
        System.out.println("The word is: " + hiddenWord);

        while (attemptsLeft > 0 && !hiddenWord.equals(wordToGuess)) {
            char guess = getPlayerGuess();
            if (isGuessCorrect(wordToGuess, guess)) {
                hiddenWord = updateHiddenWord(wordToGuess, hiddenWord, guess);
            } else {
                attemptsLeft--;
                System.out.println("Incorrect guess. Attempts left: " + attemptsLeft);
            }
            System.out.println("Current word: " + hiddenWord);
        }
        displayGameResult(wordToGuess, hiddenWord);

        // Task 2: Currency Conversion
        System.out.println("\n=== Task 2: Currency Conversion ===");
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter the source currency (USD, EUR, GBP, or JPY): ");
        String from = scanner.next().toUpperCase();
        System.out.print("Enter the target currency (USD, EUR, GBP, or JPY): ");
        String to = scanner.next().toUpperCase();
        double convertedAmount = convertCurrency(amount, from, to);
        System.out.println(amount + " " + from + " is equal to " + convertedAmount + " " + to);

        // Task 3: Remove Odd Numbers
        System.out.println("\n=== Task 3: Remove Odd Numbers ===");
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evenNums = removeOddNumbers(nums);
        System.out.print("Even numbers: ");
        for (int num : evenNums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Task 4: FizzBuzz
        System.out.println("\n=== Task 4: FizzBuzz ===");
        System.out.print("Enter a number for FizzBuzz: ");
        int fizzBuzzInput = scanner.nextInt();
        fizzBuzz(fizzBuzzInput);

        // Task 5: Two Sum Problem
        System.out.println("\n=== Task 5: Two Sum Problem ===");
        int[] nums2 = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums2, target);

        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair exists.");
        }

        scanner.close();
    }

}
