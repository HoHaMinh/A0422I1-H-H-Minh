package ss6_inheritance_bai_tap.ss6_inheritance_bai_tap_triangle;

public class TestShape {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("red");
        System.out.println(shape);
    }
}
