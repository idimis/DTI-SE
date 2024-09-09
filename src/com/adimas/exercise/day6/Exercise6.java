package com.adimas.exercise.day6;


import java.util.*;

public class Exercise6 {

    // Task 1: Java Array Program For Array Rotation
    public static void rotateArray(int[] array, int d) {
        int n = array.length;
        d = d % n; // Normalize d

        reverse(array, 0, d - 1);
        reverse(array, d, n - 1);
        reverse(array, 0, n - 1);

        System.out.println("Rotated Array:");
        System.out.println(Arrays.toString(array));
    }

    private static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    // Task 2: Check if Array Contains Duplicates
    public static boolean containsDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    // Task 3: Remove Duplicate Elements From an Array
    public static int[] removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        return result;
    }

    // Task 4: Remove All Occurrences of an Element in an Array
    public static int[] removeElement(int[] array, int key) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            if (num != key) {
                list.add(num);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    // Task 5: Reverse a String Without Using Built-in Methods
    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int left = 0, right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    // Task 6: Find All Duplicates in an Array
    public static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                duplicates.add(num);
            }
        }
        return new ArrayList<>(duplicates);
    }

    // Task 7: Get the Number of Days to Wait for a Warmer Temperature
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

        System.out.println("Select task to execute (1-7):");
        int task = scanner.nextInt();

        switch (task) {
            case 1:
                System.out.print("Enter the number of elements: ");
                int n = scanner.nextInt();
                int[] array = new int[n];
                System.out.println("Enter " + n + " integers:");
                for (int i = 0; i < n; i++) {
                    array[i] = scanner.nextInt();
                }
                System.out.print("Enter the number of positions to rotate: ");
                int d = scanner.nextInt();
                rotateArray(array, d);
                break;

            case 2:
                System.out.print("Enter the number of elements: ");
                n = scanner.nextInt();
                array = new int[n];
                System.out.println("Enter " + n + " integers:");
                for (int i = 0; i < n; i++) {
                    array[i] = scanner.nextInt();
                }
                System.out.println("Contains duplicates: " + containsDuplicates(array));
                break;

            case 3:
                System.out.print("Enter the number of elements: ");
                n = scanner.nextInt();
                array = new int[n];
                System.out.println("Enter " + n + " integers:");
                for (int i = 0; i < n; i++) {
                    array[i] = scanner.nextInt();
                }
                int[] noDuplicates = removeDuplicates(array);
                System.out.println("Array without duplicates: " + Arrays.toString(noDuplicates));
                break;

            case 4:
                System.out.print("Enter the number of elements: ");
                n = scanner.nextInt();
                array = new int[n];
                System.out.println("Enter " + n + " integers:");
                for (int i = 0; i < n; i++) {
                    array[i] = scanner.nextInt();
                }
                System.out.print("Enter the key to remove: ");
                int key = scanner.nextInt();
                int[] removedArray = removeElement(array, key);
                System.out.println("Array after removing " + key + ": " + Arrays.toString(removedArray));
                break;

            case 5:
                System.out.print("Enter the string to reverse: ");
                scanner.nextLine(); // Consume newline
                String str = scanner.nextLine();
                System.out.println("Reversed string: " + reverseString(str));
                break;

            case 6:
                System.out.print("Enter the number of elements: ");
                n = scanner.nextInt();
                array = new int[n];
                System.out.println("Enter " + n + " integers:");
                for (int i = 0; i < n; i++) {
                    array[i] = scanner.nextInt();
                }
                List<Integer> duplicates = findDuplicates(array);
                System.out.println("Duplicates: " + duplicates);
                break;

            case 7:
                System.out.print("Enter the number of temperature readings: ");
                n = scanner.nextInt();
                int[] temperatures = new int[n];
                System.out.println("Enter " + n + " temperature readings:");
                for (int i = 0; i < n; i++) {
                    temperatures[i] = scanner.nextInt();
                }
                int[] waitDays = dailyTemperatures(temperatures);
                System.out.println("Days to wait for warmer temperature: " + Arrays.toString(waitDays));
                break;

            default:
                System.out.println("Invalid task number.");
        }
        scanner.close();
    }
}
