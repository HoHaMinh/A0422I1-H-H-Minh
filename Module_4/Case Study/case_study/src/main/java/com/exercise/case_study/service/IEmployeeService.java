package com.exercise.case_study.service;

import com.exercise.case_study.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    void save(Employee employee);
    Page<Employee> showAllWithPaging (Pageable pageable);
    void remove (Integer id);
    Employee findById (Integer id);
}
