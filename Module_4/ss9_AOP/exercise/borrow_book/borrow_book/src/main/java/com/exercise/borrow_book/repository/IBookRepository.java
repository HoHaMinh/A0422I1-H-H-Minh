package com.exercise.borrow_book.repository;

import com.exercise.borrow_book.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IBookRepository extends PagingAndSortingRepository<Book, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Book b set b.bookQuantity = b.bookQuantity+1 where b.bookId=:id")
    void increaseBookQuantity(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update Book b set b.bookQuantity = b.bookQuantity-1 where b.bookId=:id")
    void decreaseBookQuantity(@Param("id") Integer id);
}
