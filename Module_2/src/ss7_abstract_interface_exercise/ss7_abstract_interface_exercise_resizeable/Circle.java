package ss7_abstract_interface_exercise.ss7_abstract_interface_exercise_resizeable;

public class Circle extends Shape implements Resizeable {
    double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    @Override
    public String toString() {
        return String.format("A circle with radius = %.1f", this.radius);
    }

    @Override
    public void resize(double percent) {
        this.radius *= (100 + percent) / 100;
    }
}
