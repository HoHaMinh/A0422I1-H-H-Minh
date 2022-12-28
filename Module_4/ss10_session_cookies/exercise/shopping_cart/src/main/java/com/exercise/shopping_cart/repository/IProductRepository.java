package com.exercise.shopping_cart.repository;


import com.exercise.shopping_cart.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
}
