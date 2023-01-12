package com.exercise.picture.service;

import com.exercise.picture.model.Comment;

import java.util.Date;
import java.util.List;

public interface ICommentService {
    public List<Comment> showCommentThisDay();
    public void save(Comment comment);

    public void updateLike (Integer id);
}
