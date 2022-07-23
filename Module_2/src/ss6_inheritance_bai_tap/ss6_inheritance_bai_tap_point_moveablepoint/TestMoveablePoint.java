package ss6_inheritance_bai_tap.ss6_inheritance_bai_tap_point_moveablepoint;

public class TestMoveablePoint {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(1, 2);
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(1, 2, 3, 4);
        System.out.println(moveablePoint);
        moveablePoint.setSpeed(5, 6);
        System.out.println(moveablePoint);
    }
}

