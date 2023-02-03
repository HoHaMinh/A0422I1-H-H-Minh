package com.exercise.case_study.repository.employee;

import com.exercise.case_study.model.employee.Position;
import org.springframework.data.repository.CrudRepository;

public interface IPositionRepository extends CrudRepository<Position,Integer> {
}
