package com.practice.shop_cart.repository;

import com.practice.shop_cart.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
}
