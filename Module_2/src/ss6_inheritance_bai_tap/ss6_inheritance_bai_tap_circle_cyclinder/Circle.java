package ss6_inheritance_bai_tap.ss6_inheritance_bai_tap_circle_cyclinder;

public class Circle {
    private double radius = 1.0;
    private String color = "white";

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    @Override
    public String toString() {
        return "A circle with radius = " + this.radius + " and color = " + this.color;
    }
}
