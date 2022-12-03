package product_manager.service;

import product_manager.bean.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll ();
    public boolean add (Product product);
    public boolean update (Product product);
    public boolean remove (Integer id);
    public Product findById (Integer id);
    public List<Product> findByName (String name);
}
