package ss5_access_modifier_practice;

public class TestStudent {
    public static void main(String[] args) {
        Student.change();
        Student student1 = new Student(111, "Hoang");
        Student student2 = new Student(222, "Khanh");
        Student student3 = new Student(333, "Nam");
        student1.display();
        student2.display();
        student3.display();
    }
}
