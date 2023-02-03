package com.exercise.case_study.service.impl.employee;

import com.exercise.case_study.model.employee.Division;
import com.exercise.case_study.repository.employee.IDivisionRepository;
import com.exercise.case_study.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public List<Division> showAll() {
        return (List<Division>) divisionRepository.findAll();
    }
}
