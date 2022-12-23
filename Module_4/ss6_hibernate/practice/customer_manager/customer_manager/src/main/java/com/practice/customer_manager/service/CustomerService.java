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
    public List<Customer> showAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer showById(Integer id) {
        return (Customer) customerRepository.findById(id).orElse(null);
    }

    @Override
    public void insert(String firstName, String lastName) {
        customerRepository.insert(firstName,lastName);
    }
}
