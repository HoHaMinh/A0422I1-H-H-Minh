package com.exercise.borrow_book.repository;

import com.exercise.borrow_book.model.BookBorrow;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBookBorrowRepository extends PagingAndSortingRepository<BookBorrow, Integer> {
}
