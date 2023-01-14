package com.exercise.blog_app_security.repository;

import com.exercise.blog_app_security.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Integer> {
}
