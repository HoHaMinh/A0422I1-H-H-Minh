package com.practice.shop_cart.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductOrderRepository extends PagingAndSortingRepository<ProductOrder,Long> {
}
