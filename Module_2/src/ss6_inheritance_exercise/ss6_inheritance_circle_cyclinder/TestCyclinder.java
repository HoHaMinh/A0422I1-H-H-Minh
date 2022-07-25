package ss6_inheritance_exercise.ss6_inheritance_circle_cyclinder;

public class TestCyclinder {
    public static void main(String[] args) {
        Cyclinder cyclinder = new Cyclinder();
        System.out.println(cyclinder);
        cyclinder = new Cyclinder(3.5, 2.5, "red");
        System.out.println(cyclinder);
        System.out.println("Volume is: " + cyclinder.getVolume());
    }
}
