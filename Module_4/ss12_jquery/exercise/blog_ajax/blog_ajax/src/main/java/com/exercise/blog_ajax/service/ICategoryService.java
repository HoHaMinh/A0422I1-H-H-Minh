package com.exercise.blog_ajax.service;

import com.exercise.blog_ajax.model.Category;
import java.util.List;

public interface ICategoryService {
    public List<Category> showAll();

    public void save(Category category);

    public void delete(Integer id);

    public Category showById(Integer id);
}
