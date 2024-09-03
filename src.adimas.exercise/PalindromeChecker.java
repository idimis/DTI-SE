package src.adimas.exercis;

import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static void main(String[] args) {
        String word = "madam";
        System.out.println(word + " is a palindrome? " + isPalindrome(word));
    }
}
