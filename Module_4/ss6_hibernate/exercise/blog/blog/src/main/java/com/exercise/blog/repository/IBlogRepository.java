package com.exercise.blog.repository;

import com.exercise.blog.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Integer> {
}
