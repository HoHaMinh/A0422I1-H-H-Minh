package com.practice.customer_manager.repository;

import com.practice.customer_manager.model.Customer;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
    @Procedure(procedureName = "Insert_Customer")
    void insert(@Param("first_name") String firstName, @Param("last_name") String lastName);
}
