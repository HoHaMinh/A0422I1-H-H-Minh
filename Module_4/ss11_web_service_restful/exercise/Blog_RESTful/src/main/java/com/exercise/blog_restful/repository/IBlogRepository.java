package com.exercise.blog_restful.repository;

import com.exercise.blog_restful.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends PagingAndSortingRepository<Blog,Integer> {
    List<Blog> findAllByCategoryIdIs(@Param("id") Integer id);
}
