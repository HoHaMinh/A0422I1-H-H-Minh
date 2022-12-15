package com.exercise.blog_app.repository;

import com.exercise.blog_app.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Integer> {
}
