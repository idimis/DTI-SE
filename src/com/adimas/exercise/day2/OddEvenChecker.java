package com.adimas.exercise.day2;

public class OddEvenChecker {
    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static void run() {
        int number = 1000;
        System.out.println(number + " is odd? " + isOdd(number));
    }
}
