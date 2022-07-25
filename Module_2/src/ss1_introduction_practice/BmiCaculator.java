package ss1_introduction_practice;

import java.util.Scanner;

public class BmiCaculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the weight (kg)");
        double weight = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the height (kg)");
        double height = Double.parseDouble(scanner.nextLine());
        double bmi = weight / Math.pow(height, 2);
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
