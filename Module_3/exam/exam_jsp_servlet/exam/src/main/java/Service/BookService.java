package Service;

import Model.Book;
import Repository.BookRepository;
import Repository.IBookRepository;

import java.util.List;

public class BookService implements IBookService{
    private IBookRepository bookRepository = new BookRepository();
    @Override
    public List<Book> showAll() {
        return bookRepository.showAll();
    }

    @Override
    public List<Book> borrow(String bookName) {
        return bookRepository.borrow(bookName);
    }
}
