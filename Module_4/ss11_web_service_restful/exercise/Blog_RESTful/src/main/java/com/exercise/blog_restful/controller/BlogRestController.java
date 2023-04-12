package com.exercise.blog_restful.controller;

import com.exercise.blog_restful.model.Blog;
import com.exercise.blog_restful.model.Category;
import com.exercise.blog_restful.service.IBlogService;
import com.exercise.blog_restful.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class BlogRestController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Category>> showAllCategory () {
        List<Category> categories = categoryService.showAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> showAllBlog () {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/{id}/blog")
    public ResponseEntity<List<Blog>> showBlogByIdCategory (@PathVariable("id") Integer idCategory) {
        List<Blog> blogs = blogService.findByCategory(idCategory);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> showBlogById (@PathVariable("id")Integer idBlog) {
        Blog blog = blogService.showById(idBlog);
        if (blog==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
