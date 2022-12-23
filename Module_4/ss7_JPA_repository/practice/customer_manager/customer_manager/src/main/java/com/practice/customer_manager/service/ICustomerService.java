package com.practice.customer_manager.service;

import com.practice.customer_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    public Page<Customer> findAllWithPaging(Pageable pageable);
    public Customer findById(Integer id);
    public void save(Customer customer);
    public void remove(Integer id);

    public Page<Customer> findAllByFirstName(String input, Pageable pageable);
}
