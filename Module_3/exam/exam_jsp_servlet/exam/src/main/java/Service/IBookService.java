package Service;

import Model.Book;

import java.util.List;

public interface IBookService {
    List<Book> showAll();
    List<Book> borrow(String bookName);
}
