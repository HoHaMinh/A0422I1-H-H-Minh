package com.exercise.blog_app.repository;

import com.exercise.blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    Page<Blog> findAllByCategoryIdIs(@Param("id") Integer id, Pageable pageable);
}
