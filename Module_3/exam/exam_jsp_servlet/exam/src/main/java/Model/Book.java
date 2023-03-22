package Model;

public class Book {
    private  String book_id;
    private String book_name;
    private String author;
    private String description;
    private int quantity;

    public Book() {
    }

    public Book(String book_id, String book_name, String author, String description, int quantity) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
