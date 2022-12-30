package com.exercise.blog_restful.service;

import com.exercise.blog_restful.model.Blog;
import com.exercise.blog_restful.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findByCategory(Integer id) {
        return blogRepository.findAllByCategoryIdIs(id);
    }

    @Override
    public Blog showById(Integer id) {
        return (Blog) blogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }
}
