package ss5_access_modifier_thuc_hanh;

public class Car {
    private String name, engine;
    public static  int numberOfCar;
    public Car (String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCar++;
    }
}
