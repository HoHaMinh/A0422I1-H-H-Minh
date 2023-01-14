package com.exercise.blog_app_security.repository;

import com.exercise.blog_app_security.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRoleRepository extends CrudRepository<Role, Long> {
    @Query("select r.roleName from Role r")
    List<String> findAllRoleName();

}
