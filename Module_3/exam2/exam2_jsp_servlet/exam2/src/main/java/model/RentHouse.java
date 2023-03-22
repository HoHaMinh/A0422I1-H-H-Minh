package model;

public class RentHouse {
    private int house_id;
    private String rent_name;
    private String phone;
    private String start_date;
    private String payment_type;
    private String note;

    public RentHouse() {
    }

    public RentHouse(String rent_name, String phone, String start_date, String payment_type, String note) {
        this.rent_name = rent_name;
        this.phone = phone;
        this.start_date = start_date;
        this.payment_type = payment_type;
        this.note = note;
    }

    public RentHouse(int house_id, String rent_name, String phone, String start_date, String payment_type, String note) {
        this.house_id = house_id;
        this.rent_name = rent_name;
        this.phone = phone;
        this.start_date = start_date;
        this.payment_type = payment_type;
        this.note = note;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public String getRent_name() {
        return rent_name;
    }

    public void setRent_name(String rent_name) {
        this.rent_name = rent_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_id(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
