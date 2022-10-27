package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> displayAll() {
        return productRepository.displayAll();
    }

    @Override
    public boolean add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public boolean edit(Product product) {
        return productRepository.edit(product);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public Product displayOneProduct() {
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
