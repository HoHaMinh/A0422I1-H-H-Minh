package Repository;

import Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository{
    private final String SELECT_ALL = "select * from book;";
    private final String UPDATE_BOOK = "update book set quantity = quantity -1 where book_name= ?;";
    @Override
    public List<Book> showAll() {
        List<Book> bookList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("book_id");
                String name = resultSet.getString("book_name");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");
                Book book = new Book(id,name,author,description,quantity);
                bookList.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> borrow(String bookName) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK)) {
            preparedStatement.setString(1, bookName);
            List<Book> bookList = new ArrayList<>();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
