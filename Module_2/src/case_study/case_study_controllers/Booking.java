package case_study.case_study_controllers;

import case_study.case_study_models.Customer;

import java.util.Date;
import java.util.Objects;

public class Booking {
    private int bookingId;
    private Date startDate;
    private Date endDate;
    private Customer customer;
    private Facility facility;

    public Booking() {
    }

    public Booking(int bookingId, Date startDate, Date endDate, Customer customer, Facility facility) {
        this.bookingId = bookingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.facility = facility;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", startDate=" + startDate.getDate() +
                "/" + (startDate.getMonth() + 1) +
                "/" + (startDate.getYear() + 1900) +
                ", endDate=" + endDate.getDate() +
                "/" + (endDate.getMonth() + 1) +
                "/" + (endDate.getYear() + 1900) + "\n" +
                ", customer Id= " + customer.getId() + "\n" +
                ", facility=" + facility.getNameOfService() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId);
    }
}
