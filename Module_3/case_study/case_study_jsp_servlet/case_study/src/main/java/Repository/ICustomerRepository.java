package Repository;

import Model.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerRepository {
    List<Customer> showAll ();
    Customer findById (int id);
    boolean add (Customer customer);
    boolean update (Customer customer);
    boolean delete (int id);

    List<Customer> search (String searchName, String searchAddress, int searchTypeId);
}
