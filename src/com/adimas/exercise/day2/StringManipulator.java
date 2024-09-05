package com.adimas.exercise.day2;

public class StringManipulator {
    public static void run() {
        String str = "Hello world";
        String searchString = "ell";
        String result = str.replaceFirst(searchString, "");
        System.out.println(result);
    }
}
