package com.exercise.borrow_book.service;

import com.exercise.borrow_book.model.BookBorrow;

public interface IBookBorrowService {
    void borrow(BookBorrow bookBorrow);

    void bringBookBack(Integer id);

    boolean isExist(Integer id);

    BookBorrow showById(Integer id);
}
