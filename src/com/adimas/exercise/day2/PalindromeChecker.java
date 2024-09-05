package com.adimas.exercise.day2;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static void run() {
        String word = "madam";
        System.out.println(word + " is a palindrome? " + isPalindrome(word));

    }
}

