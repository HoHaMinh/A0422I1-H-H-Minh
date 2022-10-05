package case_study.case_study_models;

import java.util.Date;

public class Employee extends Person {
    public Employee() {
    }

    public Employee(int id,
                    String name,
                    Date dateOfBirth,
                    String gender,
                    int nationalId,
                    int tel,
                    String email,
                    String education,
                    String position,
                    double salary) {
        super(id, name, dateOfBirth, gender, nationalId, tel, email);
        this.education = education;
        this.position = position;
        this.salary = salary;
    }

    String education;
    String position;
    double salary;

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "education='" + education + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
