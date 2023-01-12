package com.exercise.picture.repository;

import com.exercise.picture.model.BadComment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBadCommentRepository extends PagingAndSortingRepository<BadComment,Integer> {
}
