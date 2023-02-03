package com.exercise.case_study.repository.service;

import com.exercise.case_study.model.service.ServiceType;
import org.springframework.data.repository.CrudRepository;

public interface IServiceTypeRepository extends CrudRepository<ServiceType, Integer> {
}
