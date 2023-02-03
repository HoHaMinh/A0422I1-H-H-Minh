package com.exercise.case_study.service.impl.service;

import com.exercise.case_study.model.service.ServiceType;
import com.exercise.case_study.repository.service.IServiceTypeRepository;
import com.exercise.case_study.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> showAll() {
        return (List<ServiceType>) serviceTypeRepository.findAll();
    }
}
