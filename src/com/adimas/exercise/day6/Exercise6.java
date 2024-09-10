package com.adimas.exercise.day6;


import java.util.*;

public class Exercise6 {

    // Task 1: Rotate an array to the left by d elements
    public static void rotateArray(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);

        System.out.println("Rotated array: " + Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Task 2: Check if array contains duplicates
    public static boolean containsDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    // Task 3a: Remove duplicate elements from an array
    public static int[] removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }

    // Task 3b: Sort array in ascending or descending order
    public static void sortArray(int[] nums, String direction) {
        Arrays.sort(nums);
        if (direction.equals("desc")) {
            reverse(nums, 0, nums.length - 1);
        }
        System.out.println("Sorted array (" + direction + "): " + Arrays.toString(nums));
    }

    // Task 4: Remove all occurrences of a key from an array
    public static int[] removeAllOccurrences(int[] nums, int key) {
        return Arrays.stream(nums)
                .filter(num -> num != key)
                .toArray();
    }

    // Task 5: Reverse a string without using built-in methods
    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int start = 0, end = charArray.length - 1;
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return new String(charArray);
    }

    // Task 6: Find all duplicates in an array
    public static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        return new ArrayList<>(duplicates);
    }

    // Task 7: Find the number of days to wait for a warmer temperature
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Rotate Array");
            System.out.println("2. Check for Duplicates");
            System.out.println("3a. Remove Duplicates");
            System.out.println("3b. Sort Array");
            System.out.println("4. Remove All Occurrences");
            System.out.println("5. Reverse a String");
            System.out.println("6. Find Duplicates in Array");
            System.out.println("7. Daily Temperatures");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Rotate array
                    System.out.println("Enter the size of the array:");
                    int size1 = scanner.nextInt();
                    int[] arr1 = new int[size1];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < size1; i++) {
                        arr1[i] = scanner.nextInt();
                    }
                    System.out.println("Enter the number of rotations:");
                    int d = scanner.nextInt();
                    rotateArray(arr1, d);
                    break;

                case 2:
                    // Check duplicates
                    System.out.println("Enter the size of the array:");
                    int size2 = scanner.nextInt();
                    int[] arr2 = new int[size2];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < size2; i++) {
                        arr2[i] = scanner.nextInt();
                    }
                    System.out.println("Contains duplicates: " + containsDuplicates(arr2));
                    break;

                case 3:
                    // Sub-menu for Remove Duplicates (3a) and Sort Array (3b)
                    System.out.println("Choose a sub-option:");
                    System.out.println("3a. Remove Duplicates");
                    System.out.println("3b. Sort Array");
                    String subOption = scanner.next();
                    switch (subOption) {
                        case "3a":
                            // Remove duplicates
                            System.out.println("Enter the size of the array:");
                            int size3a = scanner.nextInt();
                            int[] arr3a = new int[size3a];
                            System.out.println("Enter the elements of the array:");
                            for (int i = 0; i < size3a; i++) {
                                arr3a[i] = scanner.nextInt();
                            }
                            int[] removedDup = removeDuplicates(arr3a);
                            System.out.println("Array after removing duplicates: " + Arrays.toString(removedDup));
                            break;

                        case "3b":
                            // Sort array
                            System.out.println("Enter the size of the array:");
                            int size3b = scanner.nextInt();
                            int[] arr3b = new int[size3b];
                            System.out.println("Enter the elements of the array:");
                            for (int i = 0; i < size3b; i++) {
                                arr3b[i] = scanner.nextInt();
                            }
                            System.out.println("Enter sorting direction (asc/desc):");
                            String direction = scanner.next();
                            sortArray(arr3b, direction);
                            break;

                        default:
                            System.out.println("Invalid sub-option. Please try again.");
                            break;
                    }
                    break;

                case 4:
                    // Remove all occurrences
                    System.out.println("Enter the size of the array:");
                    int size4 = scanner.nextInt();
                    int[] arr4 = new int[size4];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < size4; i++) {
                        arr4[i] = scanner.nextInt();
                    }
                    System.out.println("Enter the element to remove:");
                    int key = scanner.nextInt();
                    int[] removedOccurrences = removeAllOccurrences(arr4, key);
                    System.out.println("Array after removing element " + key + ": " + Arrays.toString(removedOccurrences));
                    break;

                case 5:
                    // Reverse string
                    System.out.println("Enter a string:");
                    String str = scanner.next();
                    System.out.println("Reversed string: " + reverseString(str));
                    break;

                case 6:
                    // Find duplicates
                    System.out.println("Enter the size of the array:");
                    int size6 = scanner.nextInt();
                    int[] arr6 = new int[size6];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < size6; i++) {
                        arr6[i] = scanner.nextInt();
                    }
                    List<Integer> duplicates = findDuplicates(arr6);
                    System.out.println("Duplicates in array: " + duplicates);
                    break;

                case 7:
                    // Daily temperatures
                    System.out.println("Enter the size of the temperatures array:");
                    int size7 = scanner.nextInt();
                    int[] temps = new int[size7];
                    System.out.println("Enter the temperatures:");
                    for (int i = 0; i < size7; i++) {
                        temps[i] = scanner.nextInt();
                    }
                    int[] daysToWait = dailyTemperatures(temps);
                    System.out.println("Days to wait for warmer temperature: " + Arrays.toString(daysToWait));
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}