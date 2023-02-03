package com.exercise.case_study.repository.employee;

import com.exercise.case_study.model.employee.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
}
