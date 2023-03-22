package Model;

public class Student {
    private int student_id;
    private String student_name;
    private String class_name;

    public Student() {
    }

    public Student(int student_id, String student_name, String class_name) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.class_name = class_name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
