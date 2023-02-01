package com.exercise.case_study.repository;


import com.exercise.case_study.model.employee.UserId;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserIdRepository extends PagingAndSortingRepository<UserId, String> {
    UserId findByUsername(String userName);
}
