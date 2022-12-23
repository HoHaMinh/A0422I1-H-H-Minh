package com.example.Repository;

import com.example.Model.Service;

import java.util.List;

public interface IServiceRepository {
    List<Service> showAll ();
    List<Service> findByName (String name);
    boolean add (Service service);
    boolean edit (Service service);
    boolean delete (int id);
}
