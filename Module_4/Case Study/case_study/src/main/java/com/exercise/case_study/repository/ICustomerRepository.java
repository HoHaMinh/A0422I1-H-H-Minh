package com.exercise.case_study.repository;

import com.exercise.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
}
