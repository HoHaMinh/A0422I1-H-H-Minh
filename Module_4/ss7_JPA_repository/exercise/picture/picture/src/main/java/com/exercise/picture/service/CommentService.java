package com.exercise.picture.service;

import com.exercise.picture.model.Comment;
import com.exercise.picture.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Page<Comment> showCommentThisDay(Pageable pageable) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        String now = format.format(new Date());
        Date currentDay;
        try {
            currentDay = format.parse(now);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return commentRepository.findCommentByDateCommentIs(currentDay, pageable);
    }

    @Override
    public void updateLike(Integer id) {
        Integer currentLike = commentRepository.findById(id).orElse(null).getNumberLike();
        if (currentLike == null) {
            currentLike = 1;
        } else {
            currentLike++;
        }
        commentRepository.updateLike(currentLike, id);
    }
}
