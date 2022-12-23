package com.practice.customer_manager.repository;

import com.practice.customer_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository <Customer,Integer> {
    Page<Customer> findAllByFirstNameContaining (String input, Pageable pageable);
}
