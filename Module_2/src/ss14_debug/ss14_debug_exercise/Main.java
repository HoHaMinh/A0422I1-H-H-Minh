package ss14_debug.ss14_debug_exercise;

import java.util.Scanner;

public class Main extends Exception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls input the first square of the triangle: ");
        double firstSquare = Double.parseDouble(scanner.nextLine());
        System.out.println("Pls input the second square of the triangle: ");
        double secondSquare = Double.parseDouble(scanner.nextLine());
        System.out.println("Pls input the third square of the triangle: ");
        double thirdSquare = Double.parseDouble(scanner.nextLine());
        while (true) {
            try {
                if (checkSquare(firstSquare, secondSquare, thirdSquare)) {
                    System.out.println("Input square is right");
                    break;
                }
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
                System.out.println("Pls enter three square again: ");
                firstSquare = Double.parseDouble(scanner.nextLine());
                secondSquare = Double.parseDouble(scanner.nextLine());
                thirdSquare = Double.parseDouble(scanner.nextLine());
            }
        }
    }

    public static boolean checkSquare(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Square can not less than or equal 0");
        }
        if (a > (b + c) || b > (a + c) || c > (a + b)) {
            throw new IllegalTriangleException("Sum of 2 square must be greater than the remain square");
        }
        return true;
    }
}
