package com.exercise.case_study.service.impl.customer;

import com.exercise.case_study.model.customer.Customer;
import com.exercise.case_study.repository.customer.ICustomerRepository;
import com.exercise.case_study.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> showAllWithPaging(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> showAll() {
        return (List<Customer>) customerRepository.findAll();
    }
}
