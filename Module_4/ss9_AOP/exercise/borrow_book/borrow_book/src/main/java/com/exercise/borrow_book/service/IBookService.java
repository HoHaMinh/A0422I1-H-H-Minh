package com.exercise.borrow_book.service;

import com.exercise.borrow_book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> showAll(Pageable pageable);

    Book showById (Integer id);
    void save(Book book);
    void increaseBookQuantity (Integer id);
    void decreaseBookQuantity(Integer id);
}
