package com.exercise.blog_ajax.controller;

import com.exercise.blog_ajax.model.Blog;
import com.exercise.blog_ajax.model.Category;
import com.exercise.blog_ajax.service.IBlogService;
import com.exercise.blog_ajax.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> showBlogBySearching(@RequestParam(value = "word", defaultValue = "") String word) {
        List<Blog> blogs = "".equals(word) ? blogService.findAll() : blogService.findByWord(word);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}/blog")
    public ResponseEntity<List<Blog>> showBlogByIdCategory(@PathVariable("id") Integer idCategory) {
        List<Blog> blogs = blogService.findByCategory(idCategory);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> showBlogById(@PathVariable("id") Integer idBlog) {
        Blog blog = blogService.showById(idBlog);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
