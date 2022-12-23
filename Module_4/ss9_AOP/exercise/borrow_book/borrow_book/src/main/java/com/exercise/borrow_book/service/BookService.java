package com.exercise.borrow_book.service;

import com.exercise.borrow_book.model.Book;
import com.exercise.borrow_book.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    IBookRepository bookRepository;
    @Override
    public Page<Book> showAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book showById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void increaseBookQuantity(Integer id) {
        bookRepository.increaseBookQuantity(id);
    }

    @Override
    public void decreaseBookQuantity(Integer id) {
        bookRepository.decreaseBookQuantity(id);
    }
}
