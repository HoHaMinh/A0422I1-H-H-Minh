package com.exercise.blog_app_security.service;

import com.exercise.blog_app_security.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    public void save(Blog blog);

    public Page<Blog> findCategoryWithPaging(Integer id, Pageable pageable);

    public Blog showById(Integer id);

    public void remove(Integer id);

    public Page<Blog> findAllWithPaging(Pageable pageable);
}
