package ss3_array_thuc_hanh;

import java.util.Scanner;

public class MinOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the length of array which you want (max is 20): ");
        int n = Integer.parseInt(scanner.nextLine());
        double[] array = new double[n];
        System.out.println("Please enter elements of array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextDouble();
        }
        scanner.nextLine();
        double min = array[0];
        System.out.printf("The min of array is: %.0f", findMin(min, array));
    }

    public static double findMin(double min, double[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}

