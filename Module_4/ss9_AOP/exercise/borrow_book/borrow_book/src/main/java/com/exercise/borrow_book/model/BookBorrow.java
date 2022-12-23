package com.exercise.borrow_book.model;

import javax.persistence.*;

@Entity
public class BookBorrow {
    @Id
    private Integer borrowId;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    public BookBorrow() {
    }

    public BookBorrow(Integer borrowId, Book book) {
        this.borrowId = borrowId;
        this.book = book;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer id) {
        this.borrowId = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
