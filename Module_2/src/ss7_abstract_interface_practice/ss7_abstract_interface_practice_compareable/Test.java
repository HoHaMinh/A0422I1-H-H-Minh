package ss7_abstract_interface_practice.ss7_abstract_interface_practice_compareable;

import ss7_abstract_interface_practice.ss7_abstract_interface_practice_compareable.CompareableCircle;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        CompareableCircle[] circles = new CompareableCircle[3];
        circles[0] = new CompareableCircle(3.6);
        circles[1] = new CompareableCircle();
        circles[2] = new CompareableCircle(3.5, "indigo", false);
        System.out.println("Pre - sorted");
        for (CompareableCircle circle : circles) {
            System.out.println(circle);
        }
        Arrays.sort(circles);

        System.out.println("After - sorted");
        for (CompareableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}
