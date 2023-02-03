package com.exercise.case_study.repository.employee;

import com.exercise.case_study.model.employee.Division;
import org.springframework.data.repository.CrudRepository;

public interface IDivisionRepository extends CrudRepository<Division,Integer> {
}
