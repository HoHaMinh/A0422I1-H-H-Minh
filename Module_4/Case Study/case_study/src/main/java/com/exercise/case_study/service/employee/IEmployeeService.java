package com.exercise.case_study.service.employee;

import com.exercise.case_study.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    void save(Employee employee);

    Page<Employee> showAllWithPaging(Pageable pageable);

    List<Employee> showAll();

    void remove(Integer id);

    Employee findById(Integer id);
}
