package com.exercise.shopping_cart.service;

import com.exercise.shopping_cart.model.ProductOrder;
import com.exercise.shopping_cart.repository.IProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderService implements IProductOrderService{
    @Autowired
    private IProductOrderRepository productOrderRepository;

    @Override
    public void save(ProductOrder productOrder) {
        productOrderRepository.save(productOrder);
    }
}
