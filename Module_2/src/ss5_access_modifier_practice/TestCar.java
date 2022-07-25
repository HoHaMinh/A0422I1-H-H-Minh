package ss5_access_modifier_practice;

public class TestCar {
    public static void main(String[] args) {
        Car car1 = new Car("Mazda 3","Sky");
        System.out.println(car1.numberOfCar);
        Car car2 = new Car("Mazda 6", "Sky");
        System.out.println(car2.numberOfCar);
    }
}
