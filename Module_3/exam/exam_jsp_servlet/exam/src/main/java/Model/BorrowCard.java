package Model;

public class BorrowCard {
    private String borrow_id;
    private int book_id;
    private int student_id;
    private boolean status;
    private String start_date;
    private String end_date;

    public BorrowCard() {
    }

    public BorrowCard(String borrow_id, int book_id, int student_id, boolean status, String start_date, String end_date) {
        this.borrow_id = borrow_id;
        this.book_id = book_id;
        this.student_id = student_id;
        this.status = status;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(String borrow_id) {
        this.borrow_id = borrow_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
