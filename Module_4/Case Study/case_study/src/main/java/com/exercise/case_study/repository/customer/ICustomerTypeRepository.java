package com.exercise.case_study.repository.customer;

import com.exercise.case_study.model.customer.CustomerType;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerTypeRepository extends CrudRepository<CustomerType,Integer> {
}
