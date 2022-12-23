package com.practice.customer_manager.service;

import com.practice.customer_manager.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ICustomerService {
    public List<Customer> showAll();
    public void save(Customer customer);
    public void delete (Integer id);
    public Customer showById (Integer id);

    public void insert(String firstName, String lastName);
}
