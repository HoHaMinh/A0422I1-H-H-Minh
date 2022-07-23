package ss6_inheritance_bai_tap.ss6_inheritance_bai_tap_triangle;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls enter color of triangle: ");
        String color = scanner.nextLine();
        System.out.println("Pls enter side 1 of triangle: ");
        double side1 = Double.parseDouble(scanner.nextLine());
        System.out.println("Pls enter side 2 of triangle: ");
        double side2 = Double.parseDouble(scanner.nextLine());
        System.out.println("Pls enter side 3 of triangle: ");
        double side3 = Double.parseDouble(scanner.nextLine());
        triangle = new Triangle(color, side1, side2, side3);
        System.out.println(triangle);
    }
}
