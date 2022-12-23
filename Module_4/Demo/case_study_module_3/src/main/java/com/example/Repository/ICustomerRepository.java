package com.example.Repository;

import com.example.Model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> showAll ();
    Customer findById (int id);
    boolean add (Customer customer);
    boolean update (Customer customer);
    boolean delete (int id);

    List<Customer> search (String searchName, String searchAddress, int searchTypeId);
}
