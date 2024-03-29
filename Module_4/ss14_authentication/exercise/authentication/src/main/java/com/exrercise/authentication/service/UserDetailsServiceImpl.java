package com.exrercise.authentication.service;

import com.exrercise.authentication.model.Account;
import com.exrercise.authentication.repository.IAccountRepository;
import com.exrercise.authentication.repository.IAccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IAccountRepository accountRepository;
    @Autowired
    IAccountRoleRepository accountRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByAccountName(username);
        if (account == null) {
            throw new UsernameNotFoundException("User do not exist");
        }

        List<String> roles = accountRoleRepository.findAllRoleByUser(username);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (String roleName: roles) {
            authorityList.add(new SimpleGrantedAuthority(roleName));
        }

        UserDetails userDetails = new User(username, account.getPassword(), authorityList);
        return userDetails;
    }
}
