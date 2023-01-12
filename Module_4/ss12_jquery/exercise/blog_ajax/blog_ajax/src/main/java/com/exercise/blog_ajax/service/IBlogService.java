package com.exercise.blog_ajax.service;

import com.exercise.blog_ajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    public void save(Blog blog);

    public List<Blog> findByCategory(Integer id);

    public Blog showById(Integer id);

    public void remove(Integer id);

    public List<Blog> findAll();

    public Page<Blog> findAllWithPaging(Pageable pageable);

    public Page<Blog> findCategoryWithPaging(Integer id, Pageable pageable);

    public List<Blog> findByWord(String word);
}
