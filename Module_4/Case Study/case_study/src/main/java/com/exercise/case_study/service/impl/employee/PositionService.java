package com.exercise.case_study.service.impl.employee;

import com.exercise.case_study.model.employee.Position;
import com.exercise.case_study.repository.employee.IPositionRepository;
import com.exercise.case_study.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public List<Position> showAll() {
        return (List<Position>) positionRepository.findAll();
    }
}
