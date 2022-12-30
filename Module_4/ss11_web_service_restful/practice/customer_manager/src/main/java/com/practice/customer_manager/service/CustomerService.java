package com.practice.customer_manager.service;

import com.practice.customer_manager.model.Customer;
import com.practice.customer_manager.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return (Customer) customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
