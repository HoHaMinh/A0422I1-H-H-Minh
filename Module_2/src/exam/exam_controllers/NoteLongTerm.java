package exam.exam_controllers;

import java.util.Date;

public class NoteLongTerm extends NoteInvestement {
    private int longTerm;
    private String bonus;

    public NoteLongTerm(String idNote, Customer customer, Date createNoteDate, Date startInvestDate,
                        double moneyInvestment, double rateInvestment, int longTerm, String bonus) {
        super(idNote, customer, createNoteDate, startInvestDate, moneyInvestment, rateInvestment);
        this.longTerm = longTerm;
        this.bonus = bonus;
    }

    public int getLongTerm() {
        return longTerm;
    }

    public void setLongTerm(int longTerm) {
        this.longTerm = longTerm;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "NoteLongTerm{" + super.toString() +
                "longTerm=" + longTerm +
                ", bonus='" + bonus + '\'' +
                '}';
    }
}
