package com.exercise.shopping_cart.repository;

import com.exercise.shopping_cart.model.ProductOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductOrderRepository extends PagingAndSortingRepository<ProductOrder,Long> {
}
