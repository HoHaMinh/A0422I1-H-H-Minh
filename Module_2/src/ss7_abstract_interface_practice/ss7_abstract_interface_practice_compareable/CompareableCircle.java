package ss7_abstract_interface_practice.ss7_abstract_interface_practice_compareable;

import ss6_inheritance_practice.Circle;

public class CompareableCircle extends Circle implements Comparable<CompareableCircle> {
    public CompareableCircle() {
    }

    public CompareableCircle(double radius) {
        super(radius);
    }

    public CompareableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(CompareableCircle o) {
        if (this.getRadius() > o.getRadius()) {
            return 1;
        } else if (this.getRadius() < o.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
