package com.exercise.case_study.repository.service;

import com.exercise.case_study.model.service.RentType;
import org.springframework.data.repository.CrudRepository;

public interface IRentTypeRepository extends CrudRepository<RentType,Integer> {
}
