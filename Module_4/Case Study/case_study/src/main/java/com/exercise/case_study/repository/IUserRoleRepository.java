package com.exercise.case_study.repository;


import com.exercise.case_study.model.employee.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserRoleRepository extends CrudRepository<UserRole,Integer> {
    @Query("select ur.role.roleName from UserRole ur where ur.userId.username = :username")
    List<String> findAllRoleByUserId(String username);

}
