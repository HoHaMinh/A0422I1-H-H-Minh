package com.exercise.blog_app_security.service;

import com.exercise.blog_app_security.model.Blog;
import com.exercise.blog_app_security.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findCategoryWithPaging(Integer id, Pageable pageable) {
        return blogRepository.findAllByCategoryIdIs(id, pageable);
    }

    @Override
    public Blog showById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllWithPaging(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
}
