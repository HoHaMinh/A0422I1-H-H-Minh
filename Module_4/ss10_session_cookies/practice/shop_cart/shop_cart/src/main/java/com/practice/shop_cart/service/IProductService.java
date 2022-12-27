package com.practice.shop_cart.service;

import com.practice.shop_cart.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
