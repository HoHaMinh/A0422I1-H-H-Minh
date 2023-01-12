package com.exercise.picture.service;

import com.exercise.picture.model.Comment;
import com.exercise.picture.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    ICommentRepository commentRepository;

    @Override
    public List<Comment> showCommentThisDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        String now = format.format(new Date());
        Date date;
        try {
            date = format.parse(now);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return commentRepository.showCommentThisDay(date);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void updateLike(Integer id) {
        Integer numbersLike = commentRepository.showNumberLike(id);
        if(numbersLike==null) {
            numbersLike = 1;
        } else {
            numbersLike++;
        }
        commentRepository.updateLike(id,numbersLike);
    }
}
