package com.exercise.validate_form.repository;

import com.exercise.validate_form.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User,Integer> {
}
