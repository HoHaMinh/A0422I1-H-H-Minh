package com.exercise.blog_restful.repository;

import com.exercise.blog_restful.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category,Integer> {
}
