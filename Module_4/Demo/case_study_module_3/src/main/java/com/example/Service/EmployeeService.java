package com.example.Service;

import com.example.Model.Employee;
import com.example.Repository.EmployeeRepository;
import com.example.Repository.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService{
    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> showAll() {
        return null;
    }

    @Override
    public List<Employee> findByName(String name) {
        return null;
    }

    @Override
    public boolean add(Employee employee) {
        return false;
    }

    @Override
    public boolean edit(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
