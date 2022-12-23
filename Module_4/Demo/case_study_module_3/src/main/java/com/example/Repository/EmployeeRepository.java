package com.example.Repository;

import com.example.Model.Employee;

import java.util.List;

public class EmployeeRepository implements IEmployeeRepository{
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
