package com.exercise.blog_ajax.repository;

import com.exercise.blog_ajax.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Integer> {
}
