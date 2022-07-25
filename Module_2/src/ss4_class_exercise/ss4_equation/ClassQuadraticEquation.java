package ss4_class_exercise.ss4_equation;

import java.util.Scanner;

public class ClassQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        scanner.nextLine();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        quadraticEquation.getA();
        quadraticEquation.getB();
        quadraticEquation.getC();
        if (quadraticEquation.getDiscriminant() < 0) {
            System.out.println("The equation has no real roots");
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("The equation has one root is: " + -b / 2 * a);
        } else {
            System.out.printf("The equation has two roots: %f and %f", quadraticEquation.getRoot1(), quadraticEquation.getRoot2());
        }
    }
}
