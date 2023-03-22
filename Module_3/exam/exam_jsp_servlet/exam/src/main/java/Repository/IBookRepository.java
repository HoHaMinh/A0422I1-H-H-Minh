package Repository;

import Model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> showAll();
    List<Book> borrow(String bookName);
}
