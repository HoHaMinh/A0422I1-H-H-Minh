package exam.exam_controllers;

import java.util.Date;

public class Customer {
    private int idCustomer;
    private String nameCustomer;
    private Date dateOfBirth;
    private String gender;
    private String tel;
    private String address;

    public Customer() {
    }

    ;

    public Customer(int idCustomer, String nameCustomer, Date dateOfBirth, String gender, String tel, String address) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.tel = tel;
        this.address = address;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", dateOfBirth=" + dateOfBirth.getDate() +
                "/" + (dateOfBirth.getMonth() + 1) +
                "/" + (dateOfBirth.getYear() + 1900) +
                ", gender='" + gender + '\'' +
                ", tel=" + tel +
                ", address='" + address + '\'' +
                '}';
    }
}
