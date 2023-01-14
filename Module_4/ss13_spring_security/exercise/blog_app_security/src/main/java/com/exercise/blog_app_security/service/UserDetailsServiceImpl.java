package com.exercise.blog_app_security.service;

import com.exercise.blog_app_security.model.Account;
import com.exercise.blog_app_security.model.Role;
import com.exercise.blog_app_security.repository.IAccountRepository;
import com.exercise.blog_app_security.repository.IRoleRepository;
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
    IAccountRepository accountRepository;

    @Autowired
    IRoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByAccountName(username);
        if (account == null) {
            throw new UsernameNotFoundException("User do not exist");
        }

        List<String> roles=new ArrayList<>();
        roles.add(account.getRole().getRoleName());
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (String roleName: roles) {
            authorityList.add(new SimpleGrantedAuthority(roleName));
        }

        UserDetails userDetails = new User(username, account.getPassword(), authorityList);
        return userDetails;
    }
}
