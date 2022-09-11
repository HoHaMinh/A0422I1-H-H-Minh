package exam.exam_controllers;

import java.util.Date;

public class NoteShortTerm extends NoteInvestement {
    private int shortTerm;

    public NoteShortTerm(String idNote, Customer customerId, Date createNoteDate, Date startInvestDate,
                         double moneyInvestment, double rateInvestment, int shortTerm) {
        super(idNote, customerId, createNoteDate, startInvestDate, moneyInvestment, rateInvestment);
        this.shortTerm = shortTerm;
    }

    public int getShortTerm() {
        return shortTerm;
    }

    public void setShortTerm(int shortTerm) {
        this.shortTerm = shortTerm;
    }

    @Override
    public String toString() {
        return "NoteShortTerm{" + super.toString() +
                "shortTerm=" + shortTerm +
                '}';
    }
}
