package ss7_abstract_interface_exercise.ss7_abstract_interface_exercise_resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    @Override
    public String toString() {
        return String.format("A rectangle with width = %.1f, and length = %.1f", this.width, this.length);
    }

    @Override
    public void resize(double percent) {
        this.width *= (100 + percent) / 100;
        this.length *= (100 + percent) / 100;
    }
}
