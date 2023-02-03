package com.exercise.case_study.repository.customer;

import com.exercise.case_study.model.customer.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
}
