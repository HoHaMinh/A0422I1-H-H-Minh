package com.exercise.case_study.service.impl.service;

import com.exercise.case_study.model.service.Service;
import com.exercise.case_study.repository.service.IServiceRepository;
import com.exercise.case_study.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Page<Service> showAllWithPaging(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<Service> showAll() {
        return (List<Service>) serviceRepository.findAll();
    }
}
