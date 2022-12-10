package com.exercise.blog.service;

import com.exercise.blog.model.Blog;
import com.exercise.blog.repository.IBlogRepository;
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
    public List<Blog> showAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog showById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }
}
