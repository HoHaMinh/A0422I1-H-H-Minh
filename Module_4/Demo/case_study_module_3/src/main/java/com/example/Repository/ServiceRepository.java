package com.example.Repository;

import com.example.Model.Service;

import java.util.List;

public class ServiceRepository implements IServiceRepository{
    @Override
    public List<Service> showAll() {
        return null;
    }

    @Override
    public List<Service> findByName(String name) {
        return null;
    }

    @Override
    public boolean add(Service service) {
        return false;
    }

    @Override
    public boolean edit(Service service) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
