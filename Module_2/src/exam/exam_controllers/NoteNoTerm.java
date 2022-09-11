package exam.exam_controllers;

import java.util.Date;

public class NoteNoTerm extends NoteInvestement {
    public NoteNoTerm(String idNote, Customer customerId, Date createNoteDate, Date startInvestDate,
                      double moneyInvestment, double rateInvestment) {
        super(idNote, customerId, createNoteDate, startInvestDate, moneyInvestment, rateInvestment);
    }

    @Override
    public String toString() {
        return "NoteNoTerm{" + super.toString() + "}";
    }
}
