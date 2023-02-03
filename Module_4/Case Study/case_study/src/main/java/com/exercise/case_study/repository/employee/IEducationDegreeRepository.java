package com.exercise.case_study.repository.employee;

import com.exercise.case_study.model.employee.EducationDegree;
import org.springframework.data.repository.CrudRepository;

public interface IEducationDegreeRepository extends CrudRepository<EducationDegree,Integer> {
}
