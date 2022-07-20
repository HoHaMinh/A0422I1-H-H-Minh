package ss4_class_bai_tap.ss4_class_bai_tap_fan;

public class ClassFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setTurnOn(true);
        fan1.isTurnOn();
        fan1.setSpeed(3);
        fan1.getSpeed();
        fan1.setRadius(10);
        fan1.getRadius();
        fan1.setColor("yellow");
        fan1.getColor();
        System.out.println(fan1.toString());
        Fan fan2 = new Fan();
        fan2.setTurnOn(false);
        fan2.isTurnOn();
        fan2.setSpeed(2);
        fan2.getSpeed();
        fan2.getRadius();
        fan2.getColor();
        System.out.println(fan2.toString());
    }
}
