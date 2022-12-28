package com.exercise.shopping_cart.service;

import com.exercise.shopping_cart.model.Product;
import com.exercise.shopping_cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return (Product) productRepository.findById(id).orElse(null);
    }
}
