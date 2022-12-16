package com.exercise.validate_form.service;

import com.exercise.validate_form.model.User;
import com.exercise.validate_form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> showAll() {
        return (List<User>) userRepository.findAll();
    }
}
