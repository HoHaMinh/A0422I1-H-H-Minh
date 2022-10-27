package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> displayAll();
    boolean add (Product product);
    boolean edit (Product product);
    boolean delete (int id);
    Product displayOneProduct();
    List<Product> findByName(String name);
    Product findById (int id);
}
