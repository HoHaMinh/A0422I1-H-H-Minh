package com.exercise.picture.repository;

import com.exercise.picture.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public interface ICommentRepository extends PagingAndSortingRepository<Comment, Integer> {
    Page<Comment> findCommentByDateCommentIs(@Param("now") Date now, Pageable pageable);

    @Modifying
    @Query(value = "UPDATE Comment c set c.numberLike = :numberLike where c.id = :id")
    void updateLike(@Param("numberLike") Integer numberLike, @Param("id") Integer id);
}
