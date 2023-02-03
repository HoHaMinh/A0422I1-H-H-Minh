package com.exercise.case_study.service.impl.service;

import com.exercise.case_study.model.service.RentType;
import com.exercise.case_study.repository.service.IRentTypeRepository;
import com.exercise.case_study.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> showAll() {
        return (List<RentType>) rentTypeRepository.findAll();
    }
}
