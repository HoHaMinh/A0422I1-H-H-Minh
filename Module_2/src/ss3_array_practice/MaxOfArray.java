package ss3_array_practice;

import java.util.Scanner;

public class MaxOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the numbers billionaires which you want to input (max is 20): ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n < 1 || n > 20) {
            System.out.println("Your input is less than 1 or greater than 20");
        } else {
            double[] array = new double[n];
            for (int i = 0; i < n; i++) {
                System.out.printf("Please enter values of billionaires %d: ", i + 1);
                array[i] = Double.parseDouble(scanner.nextLine());
            }
            double max = 0;
            int index = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                    index = i + 1;
                }
            }
            System.out.printf("The billionaire in positon %d is richest, having value is %.0f", index, max);
        }
    }
}
