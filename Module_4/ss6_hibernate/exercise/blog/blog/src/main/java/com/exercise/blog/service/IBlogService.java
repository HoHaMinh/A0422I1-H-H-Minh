package com.exercise.blog.service;

import com.exercise.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    public void save(Blog blog);
    public List<Blog> showAll();
    public Blog showById(Integer id);
    public void remove(Integer id);
}
