package com.exercise.case_study.service.customer;

import com.exercise.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    void save(Customer customer);
    Page<Customer> showAllWithPaging (Pageable pageable);
    void remove (Integer id);
    Customer findById (Integer id);
    List<Customer> showAll();
}
