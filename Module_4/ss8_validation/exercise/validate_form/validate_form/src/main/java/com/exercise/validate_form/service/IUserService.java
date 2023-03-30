package com.exercise.validate_form.service;

import com.exercise.validate_form.model.User;

import java.util.List;

public interface IUserService {
    public void save(User user);

    public List<User> showAll();
}
