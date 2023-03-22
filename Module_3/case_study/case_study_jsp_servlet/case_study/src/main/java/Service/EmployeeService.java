package Service;

import Model.Employee;
import Repository.EmployeeRepository;
import Repository.IEmployeeRepository;

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
