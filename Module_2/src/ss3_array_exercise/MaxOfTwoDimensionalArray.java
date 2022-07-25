package ss3_array_exercise;

import java.util.Scanner;

public class MaxOfTwoDimensionalArray {
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
        double max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        System.out.println("Max is: " + max);
    }
}
