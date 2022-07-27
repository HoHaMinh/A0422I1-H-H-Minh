package ss7_abstract_interface_exercise.ss7_abstract_interface_exercise_resizeable;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(3, 4);
        shapes[2] = new Square(6);
        for (Shape shape : shapes) {
            System.out.printf("The area of %s at pre - resize is: %.1f \n", shape, shape.getArea());
            shape.resize(Math.random() * 100);
            System.out.printf("The area of %s at after - resize is: %.1f \n", shape, shape.getArea());
        }
    }
}
