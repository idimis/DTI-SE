import java.util.Scanner;

public class Exercises {

    // Method 1: Calculate the sum of digits in a given number
    public static void sumOfDigits() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        System.out.println("Sum of digits: " + sum);
    }

    // Method 2: Check if a number is prime
    public static void checkPrime() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        boolean isPrime = number > 1;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println("Is the number prime? " + isPrime);
    }

    // Method 3: Find the largest element in an array
    public static void findLargestElement() {
        int[] array = {3, 7, 2, 8, 1};
        int largest = array[0];
        for (int num : array) {
            if (num > largest) {
                largest = num;
            }
        }
        System.out.println("Largest element: " + largest);
    }

    // Method 4: Simple calculator for addition, subtraction, multiplication, and division
    public static void simpleCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }
        System.out.println("Result: " + result);
    }

    // Method 5: Reverse a string without using built-in reverse functions
    public static void reverseString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        System.out.println("Reversed string: " + reversed);
    }

    // Method 6: Generate the Fibonacci sequence up to n terms
    public static void fibonacciSequence() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();
        int a = 0, b = 1;
        System.out.print("Fibonacci sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    // Method 7: Count the number of vowels in a string
    public static void countVowels() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        int count = 0;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.println("Number of vowels: " + count);
    }

    // Method 8: Sort an array of integers using bubble sort
    public static void bubbleSort() {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.print("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Method 9: Check if two strings are anagrams
    public static void checkAnagram() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();

        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);

        boolean isAnagram = java.util.Arrays.equals(arr1, arr2);
        System.out.println("Are the strings anagrams? " + isAnagram);
    }

    // Method 10: Find the second-smallest element in an array
    public static void findSecondSmallest() {
        int[] array = {5, 3, 8, 1, 2, 9};
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : array) {
            if (num < first) {
                second = first;
                first = num;
            } else if (num < second && num != first) {
                second = num;
            }
        }
        System.out.println("Second smallest element: " + second);
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an exercise to run (1-10): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                sumOfDigits();
                break;
            case 2:
                checkPrime();
                break;
            case 3:
                findLargestElement();
                break;
            case 4:
                simpleCalculator();
                break;
            case 5:
                reverseString();
                break;
            case 6:
                fibonacciSequence();
                break;
            case 7:
                countVowels();
                break;
            case 8:
                bubbleSort();
                break;
            case 9:
                checkAnagram();
                break;
            case 10:
                findSecondSmallest();
                break;
            default:
                System.out.println("Invalid choice. Please select a number between 1 and 10.");
                break;
        }
    }
}
