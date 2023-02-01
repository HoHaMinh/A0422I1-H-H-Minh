package com.exercise.case_study.service;


import com.exercise.case_study.model.employee.UserId;
import com.exercise.case_study.repository.IUserIdRepository;
import com.exercise.case_study.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IUserIdRepository userIdRepository;

    @Autowired
    IUserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserId userId = userIdRepository.findByUsername(username);
        if (userId == null) {
            throw new UsernameNotFoundException("User do not exist");
        }

        List<String> roles= userRoleRepository.findAllRoleByUserId(username);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (String roleName: roles) {
            authorityList.add(new SimpleGrantedAuthority(roleName));
        }

        UserDetails userDetails = new User(username, userId.getPassword(), authorityList);
        return userDetails;
    }
}
