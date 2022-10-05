package case_study.case_study_models;

import java.util.Date;

public abstract class Person {
    private int id;
    private String name;
    private Date dateOfBirth;
    private String gender;
    private int nationalId;
    private int tel;
    private String email;

    public Person() {
    }

    public Person(int personCode, String fullName, Date dateOfBirth, String gender, int nationalId, int tel, String email) {
        this.id = personCode;
        this.name = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationalId = nationalId;
        this.tel = tel;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth.getDate() +
                "/" + (dateOfBirth.getMonth() + 1) +
                "/" + (dateOfBirth.getYear() + 1900) +
                ", gender='" + gender + '\'' +
                ", nationalId=" + nationalId +
                ", tel=" + tel +
                ", email='" + email + '\'' + ", ";
    }
}
