package ss6_inheritance_exercise.ss6_inheritance_circle_cyclinder;

public class Cyclinder extends Circle {
    private double height = 1.0;

    public Cyclinder() {
    }

    public Cyclinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "A cyclinder with height = " + this.height + ", which is a subclass of " + super.toString();
    }
}
