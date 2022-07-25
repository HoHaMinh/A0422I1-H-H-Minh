package ss3_array_practice;

import java.util.Scanner;

public class ArrayReversing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the length of array which you want (max is 20): ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n < 1 || n > 20) {
            System.out.println("Your input is less than 1 or greater than 20");
        } else {
            double[] array = new double[n];
            for (int i = 0; i < n; i++) {
                System.out.printf("Please enter elements of index %d of array: ", i);
                array[i] = Double.parseDouble(scanner.nextLine());
            }
            System.out.println("Original array is: ");
            for (double item : array) {
                System.out.printf("%.0f\t", item);
            }
            for (int i = 0; i < array.length / 2; i++) {
                double temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }
            System.out.println();
            System.out.println("Reverse array is: ");
            for (double item : array) {
                System.out.printf("%.0f\t", item);
            }
        }
    }
}
