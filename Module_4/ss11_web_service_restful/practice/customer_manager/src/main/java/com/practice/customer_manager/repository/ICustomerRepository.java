package com.practice.customer_manager.repository;

import com.practice.customer_manager.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
}
