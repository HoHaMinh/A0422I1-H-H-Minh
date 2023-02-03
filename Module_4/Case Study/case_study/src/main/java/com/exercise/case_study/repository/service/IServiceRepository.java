package com.exercise.case_study.repository.service;

import com.exercise.case_study.model.service.Service;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IServiceRepository extends PagingAndSortingRepository<Service,Integer> {
}
