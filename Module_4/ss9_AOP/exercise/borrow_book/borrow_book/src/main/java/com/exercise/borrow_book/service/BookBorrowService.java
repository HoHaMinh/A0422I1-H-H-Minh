package com.exercise.borrow_book.service;

import com.exercise.borrow_book.model.BookBorrow;
import com.exercise.borrow_book.repository.IBookBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookBorrowService implements IBookBorrowService{
    @Autowired
    IBookBorrowRepository bookBorrowRepository;
    @Override
    public void borrow(BookBorrow bookBorrow) {
        bookBorrowRepository.save(bookBorrow);
    }

    @Override
    public void bringBookBack(Integer id) {
        bookBorrowRepository.deleteById(id);
    }

    @Override
    public boolean isExist(Integer id) {
        return bookBorrowRepository.existsById(id);
    }

    @Override
    public BookBorrow showById(Integer id) {
        return bookBorrowRepository.findById(id).orElse(null);
    }
}
