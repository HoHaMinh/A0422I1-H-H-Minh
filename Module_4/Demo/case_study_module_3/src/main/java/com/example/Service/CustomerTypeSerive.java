package com.example.Service;

import com.example.Model.CustomerType;
import com.example.Repository.ICustomerTypeRepository;
import com.example.Repository.CustomerTypeRepository;

import java.util.List;

public class CustomerTypeSerive implements ICustomerTypeSerivce{
    private ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    @Override
    public List<CustomerType> showAll() {
        return customerTypeRepository.showAll();
    }
}
