package ss6_inheritance_exercise.ss6_inheritance_triangle;

public class TestShape {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("red");
        System.out.println(shape);
    }
}
