package case_study.case_study_controllers;

import case_study.case_study_models.Customer;

public class Contract {
    private int contractNo;
    private double advancePayment;
    private double totalPayment;
    private Booking booking;
    private Customer customer;

    public Contract() {
    }

    public Contract(int contractNo, double advancePayment, double totalPayment, Booking booking, Customer customer) {
        this.contractNo = contractNo;
        this.advancePayment = advancePayment;
        this.totalPayment = totalPayment;
        this.booking = booking;
        this.customer = customer;
    }

    public int getContractNo() {
        return contractNo;
    }

    public void setContractNo(int contractNo) {
        this.contractNo = contractNo;
    }

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNo=" + contractNo +
                ", advancePayment=" + advancePayment +
                ", totalPayment=" + totalPayment +
                ", booking=" + booking +
                '}';
    }
}
