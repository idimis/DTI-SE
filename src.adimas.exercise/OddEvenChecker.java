public class OddEvenChecker {
    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static void main(String[] args) {
        int number = 1000;
        System.out.println(number + " is odd? " + isOdd(number));
    }
}
