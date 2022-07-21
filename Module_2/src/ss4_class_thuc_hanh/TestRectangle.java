package ss4_class_thuc_hanh;

import java.util.Scanner;

public class TestRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls enter the width: ");
        double width = Double.parseDouble(scanner.nextLine());
        System.out.println("Pls enter the height: ");
        double height = Double.parseDouble(scanner.nextLine());
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your rectangle: " + rectangle.display());
        System.out.println("The area of rectangle is: " + rectangle.getArea());
        System.out.println("The perimeter of rectangle is: " + rectangle.getPerimeter());
    }
}
