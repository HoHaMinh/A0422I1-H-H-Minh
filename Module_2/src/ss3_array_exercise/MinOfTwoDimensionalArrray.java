package ss3_array_exercise;

import java.util.Scanner;

public class MinOfTwoDimensionalArrray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the row of matrix array: ");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the column of matrix array: ");
        int column = Integer.parseInt(scanner.nextLine());
        int[][] array = new int[row][column];
        System.out.println("Please enter elements of array");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine();
        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (min > array[i][j]) {
                    min = array[i][j];
                }
            }
        }
        System.out.println("Min is: " + min);
    }
}
