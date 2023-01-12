package com.exercise.picture.repository;

import com.exercise.picture.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;

public interface ICommentRepository extends PagingAndSortingRepository<Comment,Integer> {
    @Query(value = "select c from Comment c where c.dateComment = :now")
    public List<Comment> showCommentThisDay(@Param("now") Date date);
    @Query("select c.numberLike from Comment c where c.id= :id")
    public Integer showNumberLike(@Param("id")Integer id);

    @Query("UPDATE Comment c set c.numberLike = :numbersLike where c.id = :id")
    public void updateLike(@Param("id") Integer id, @Param("numbersLike") Integer numbersLike);
}
