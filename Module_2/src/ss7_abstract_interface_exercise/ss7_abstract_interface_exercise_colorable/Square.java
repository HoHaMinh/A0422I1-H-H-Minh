package ss7_abstract_interface_exercise.ss7_abstract_interface_exercise_colorable;

public class Square extends Shape implements Colorable {
    private double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public String toString() {
        return String.format("A square with side= %.1f", this.getSide());
    }

    @Override
    public String howToColor() {
        return "color all four sides";
    }
}
