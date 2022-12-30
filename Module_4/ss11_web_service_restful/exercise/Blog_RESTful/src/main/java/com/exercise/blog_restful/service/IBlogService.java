package com.exercise.blog_restful.service;

import com.exercise.blog_restful.model.Blog;

import java.util.List;

public interface IBlogService {
    public void save(Blog blog);

    public List<Blog> findByCategory(Integer id);

    public Blog showById(Integer id);

    public void remove(Integer id);

    public List<Blog> findAll();
}
