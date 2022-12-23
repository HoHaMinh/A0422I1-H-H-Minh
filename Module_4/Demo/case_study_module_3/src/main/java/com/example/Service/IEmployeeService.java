package com.example.Service;

import com.example.Model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> showAll ();
    List<Employee> findByName (String name);
    boolean add (Employee employee);
    boolean edit (Employee employee);
    boolean delete (int id);
}
