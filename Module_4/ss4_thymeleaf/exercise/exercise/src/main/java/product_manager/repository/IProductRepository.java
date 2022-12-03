package product_manager.repository;

import product_manager.bean.Product;

import java.util.List;

public interface IProductRepository {
    public List<Product> findAll ();
    public boolean add (Product product);
    public boolean update (Product product);
    public boolean remove (Integer id);
    public Product findById (Integer id);
    public List<Product> findByName (String name);
}
