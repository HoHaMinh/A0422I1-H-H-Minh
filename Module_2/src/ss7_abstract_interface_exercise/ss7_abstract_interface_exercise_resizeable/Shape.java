package ss7_abstract_interface_exercise.ss7_abstract_interface_exercise_resizeable;

public abstract class Shape implements Resizeable {

    public abstract double getArea();

    @Override
    public String toString() {
        return "a shape";
    }
}
