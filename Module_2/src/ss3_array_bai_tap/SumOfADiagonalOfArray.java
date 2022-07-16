package ss3_array_bai_tap;

import java.util.Scanner;

public class SumOfADiagonalOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the row and column of matrix array: ");
        int number = Integer.parseInt(scanner.nextLine());
        double[][] array = new double[number][number];
        System.out.println("Please enter elements of array");
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                array[i][j] = scanner.nextDouble();
            }
        }
        scanner.nextLine();
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        System.out.printf("Sum of diagonal is: " + sum);
    }
}
