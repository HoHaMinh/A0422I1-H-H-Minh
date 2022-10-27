package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayAll();
    boolean add (Product product);
    boolean edit (Product product);
    boolean delete (int id);
    Product displayOneProduct();
    List<Product> findByName(String name);

    Product findById (int id);

}
