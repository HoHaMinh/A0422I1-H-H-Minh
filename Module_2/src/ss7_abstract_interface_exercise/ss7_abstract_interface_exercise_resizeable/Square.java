package ss7_abstract_interface_exercise.ss7_abstract_interface_exercise_resizeable;

public class Square extends Shape implements Resizeable {
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
    public void resize(double percent) {
        this.side *= (100 + percent) / 100;
    }

}
