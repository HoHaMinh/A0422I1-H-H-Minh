package exam.exam_controllers;

import java.util.Date;

public abstract class NoteInvestement {
    private String idNote;
    public Customer customer;
    private Date createNoteDate;
    private Date startInvestDate;
    private double moneyInvestment;
    private double rateInvestment;

    public NoteInvestement(String idNote, Customer customer, Date createNoteDate, Date startInvestDate, double moneyInvestment, double rateInvestment) {
        this.idNote = idNote;
        this.customer = customer;
        this.createNoteDate = createNoteDate;
        this.startInvestDate = startInvestDate;
        this.moneyInvestment = moneyInvestment;
        this.rateInvestment = rateInvestment;
    }

    public String getIdNote() {
        return idNote;
    }

    public void setIdNote(String idNote) {
        this.idNote = idNote;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreateNoteDate() {
        return createNoteDate;
    }

    public void setCreateNoteDate(Date createNoteDate) {
        this.createNoteDate = createNoteDate;
    }

    public Date getStartInvestDate() {
        return startInvestDate;
    }

    public void setStartInvestDate(Date startInvestDate) {
        this.startInvestDate = startInvestDate;
    }

    public double getMoneyInvestment() {
        return moneyInvestment;
    }

    public void setMoneyInvestment(double moneyInvestment) {
        this.moneyInvestment = moneyInvestment;
    }

    public double getRateInvestment() {
        return rateInvestment;
    }

    public void setRateInvestment(double rateInvestment) {
        this.rateInvestment = rateInvestment;
    }

    @Override
    public String toString() {
        return "idNote=" + idNote +
                ", customerId=" + customer.getIdCustomer() +
                ", createNoteDate=" + createNoteDate.getDate() +
                "/" + (createNoteDate.getMonth() + 1) +
                "/" + (createNoteDate.getYear() + 1900) +
                ", startInvestDate=" + startInvestDate.getDate() +
                "/" + (startInvestDate.getMonth() + 1) +
                "/" + (startInvestDate.getYear() + 1900) +
                ", moneyInvestment=" + moneyInvestment +
                ", rateInvestment=" + rateInvestment +
                " ,";
    }
}
