package ss6_inheritance_bai_tap.ss6_inheritance_bai_tap_circle_cyclinder;

import ss6_inheritance_bai_tap.ss6_inheritance_bai_tap_circle_cyclinder.Circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(3.5, "green");
        System.out.println(circle);
        System.out.println("The area is: " + circle.getArea());
    }
}
