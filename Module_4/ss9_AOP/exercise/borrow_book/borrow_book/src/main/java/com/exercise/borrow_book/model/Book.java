package com.exercise.borrow_book.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;
    private Integer bookQuantity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "borrowId")
    private List<BookBorrow> bookBorrowList;

    public Book() {
    }

    public Book(String bookName, Integer bookQuantity, List<BookBorrow> bookBorrowList) {
        this.bookName = bookName;
        this.bookQuantity = bookQuantity;
        this.bookBorrowList = bookBorrowList;
    }

    public Book(String bookName, Integer bookQuantity) {
        this.bookName = bookName;
        this.bookQuantity = bookQuantity;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public List<BookBorrow> getBookBorrowList() {
        return bookBorrowList;
    }

    public void setBookBorrowList(List<BookBorrow> bookBorrowList) {
        this.bookBorrowList = bookBorrowList;
    }
}
