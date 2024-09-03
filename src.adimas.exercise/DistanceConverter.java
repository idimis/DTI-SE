package src.adimas.exercise;
import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        int centimeters = 100000;
        double kilometers = centimeters / 100000.0;
        System.out.println(centimeters + " cm = " + kilometers + " km");
    }
}
