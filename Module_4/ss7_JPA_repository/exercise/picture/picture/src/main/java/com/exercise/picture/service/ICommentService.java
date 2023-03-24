package com.exercise.picture.service;

import com.exercise.picture.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICommentService {
    public void save(Comment comment);

    public Page<Comment> showCommentThisDay(Pageable pageable);

    public void updateLike(Integer id);
}
