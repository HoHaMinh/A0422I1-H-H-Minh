package ss3_array_practice;

import java.util.Scanner;

public class StudentsCounting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter numbers scores which you want to input (max is 30): ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n < 1 || n > 30) {
            System.out.println("Your input is less than 1 or greater than 30");
        } else {
            double[] array = new double[n];
            for (int i = 0; i < n; i++) {
                System.out.printf("Please enter scores (0-10) has index %d is: ", i + 1);
                array[i] = Double.parseDouble(scanner.nextLine());
                while (array[i] < 0 && array[i] > 10) {
                    System.out.println("Your input is less than 0 or greater than 10. Please input again");
                    array[i] = scanner.nextDouble();
                }
            }
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] >= 5) {
                    count++;
                }
            }
            System.out.println("The passed students are: " + count);
        }
    }
}
