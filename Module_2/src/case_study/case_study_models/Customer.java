package case_study.case_study_models;

import java.util.Date;

public class Customer extends Person {
    public Customer() {
    }

    public Customer(int id,
                    String name,
                    Date dateOfBirth,
                    String gender,
                    int nationalId,
                    int tel,
                    String email,
                    String typeOfCustomer,
                    String address) {
        super(id, name, dateOfBirth, gender, nationalId, tel, email);
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    String typeOfCustomer;
    String address;

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
