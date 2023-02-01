package com.exercise.case_study.service;

import com.exercise.case_study.model.service.Service;
import com.exercise.case_study.repository.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService{
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }
}
