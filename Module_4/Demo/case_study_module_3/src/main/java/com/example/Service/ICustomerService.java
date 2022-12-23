package com.example.Service;

import com.example.Model.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> showAll ();
    Customer findById (int id);
    Map<String,String> add (Customer customer);
    boolean update (Customer customer);
    boolean delete (int id);

    List<Customer> search (String searchName, String searchAddress, int searchTypeId);
}
