package com.exercise.case_study.service.impl.employee;

import com.exercise.case_study.model.employee.EducationDegree;
import com.exercise.case_study.repository.employee.IEducationDegreeRepository;
import com.exercise.case_study.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;


    @Override
    public List<EducationDegree> showAll() {
        return (List<EducationDegree>) educationDegreeRepository.findAll();
    }
}
