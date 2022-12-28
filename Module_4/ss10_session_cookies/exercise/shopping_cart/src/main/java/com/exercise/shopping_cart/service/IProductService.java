package com.exercise.shopping_cart.service;

import com.exercise.shopping_cart.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
