package ss5_access_modifier_bai_tap.ss5_access_modifier_bai_tap_circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Radius is: " + circle.getRadius());
        System.out.println("Area of circle is: " + circle.getArea());
    }
}
