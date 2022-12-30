package com.practice.customer_manager.service;

import com.practice.customer_manager.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    Customer save (Customer customer);
    void remove(Long id);
}
