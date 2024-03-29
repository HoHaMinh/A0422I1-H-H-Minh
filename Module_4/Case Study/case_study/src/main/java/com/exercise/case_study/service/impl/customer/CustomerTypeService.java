package com.exercise.case_study.service.impl.customer;

import com.exercise.case_study.model.customer.CustomerType;
import com.exercise.case_study.repository.customer.ICustomerTypeRepository;
import com.exercise.case_study.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> showAll() {
        return (List<CustomerType>) customerTypeRepository.findAll();
    }
}
