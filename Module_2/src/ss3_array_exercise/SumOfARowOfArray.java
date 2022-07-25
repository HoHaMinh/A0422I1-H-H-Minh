package ss3_array_exercise;

import java.util.Scanner;

public class SumOfARowOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the row of matrix array: ");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the column of matrix array: ");
        int column = Integer.parseInt(scanner.nextLine());
        double[][] array = new double[row][column];
        System.out.println("Please enter elements of array");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = scanner.nextDouble();
            }
        }
        scanner.nextLine();
        System.out.println("Please enter the column you want to choose: ");
        int choice = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        for (double[] doubles : array) {
            sum += doubles[choice - 1];
        }
        System.out.printf("Sum of column %d is %.00f", choice, sum);
    }
}
