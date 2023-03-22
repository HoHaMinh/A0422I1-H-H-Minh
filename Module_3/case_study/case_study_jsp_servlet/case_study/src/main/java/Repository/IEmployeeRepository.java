package Repository;


import Model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> showAll ();
    List<Employee> findByName (String name);
    boolean add (Employee employee);
    boolean edit (Employee employee);
    boolean delete (int id);
}
