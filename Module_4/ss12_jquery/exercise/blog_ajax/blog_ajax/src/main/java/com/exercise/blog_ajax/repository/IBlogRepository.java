package com.exercise.blog_ajax.repository;

import com.exercise.blog_ajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IBlogRepository extends PagingAndSortingRepository<Blog,Integer> {
    List<Blog> findAllByCategoryIdIs(@Param("id") Integer id);
    Page<Blog> findAllByCategoryIdIs(@Param("id") Integer id, Pageable pageable);

    List<Blog> findAllByContentContains(@Param("word") String word);
}
