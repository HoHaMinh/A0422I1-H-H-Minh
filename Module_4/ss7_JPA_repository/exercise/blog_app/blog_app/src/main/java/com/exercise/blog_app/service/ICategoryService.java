package com.exercise.blog_app.service;

import com.exercise.blog_app.model.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> showAll();

    public void save(Category category);

    public void delete(Integer id);

    public Category showById(Integer id);
}
