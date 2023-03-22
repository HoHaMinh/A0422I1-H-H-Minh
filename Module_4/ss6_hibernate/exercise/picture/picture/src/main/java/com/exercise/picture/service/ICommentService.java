package com.exercise.picture.service;

import com.exercise.picture.model.Comment;
import java.util.List;

public interface ICommentService {
    public void save(Comment comment);

    public List<Comment> showCommentThisDay();

    public void updateLike(Integer id);
}
