package com.example.Service;

import com.example.Model.Service;
import com.example.Repository.IServiceRepository;
import com.example.Repository.ServiceRepository;

import java.util.List;

public class ServiceService implements IServiceService{
    private IServiceRepository serviceRepository = new ServiceRepository();
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
