package ss7_abstract_interface_exercise.ss7_abstract_interface_exercise_colorable;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(5, 6);
        shapes[2] = new Square(4);
        for (Shape shape : shapes) {
            System.out.printf("- The area of %s is: %.1f \n", shape, shape.getArea());
            if (shape instanceof Colorable) {
                System.out.println("The square is " + ((Colorable) shape).howToColor());
            }
        }
    }
}
