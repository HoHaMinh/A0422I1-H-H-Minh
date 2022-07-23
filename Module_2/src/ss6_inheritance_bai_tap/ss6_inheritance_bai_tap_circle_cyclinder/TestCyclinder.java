package ss6_inheritance_bai_tap.ss6_inheritance_bai_tap_circle_cyclinder;

import ss6_inheritance_bai_tap.ss6_inheritance_bai_tap_circle_cyclinder.Cyclinder;

public class TestCyclinder {
    public static void main(String[] args) {
        Cyclinder cyclinder = new Cyclinder();
        System.out.println(cyclinder);
        cyclinder = new Cyclinder(3.5, 2.5, "red");
        System.out.println(cyclinder);
        System.out.println("Volume is: " + cyclinder.getVolume());
    }
}
