package com.exercise.picture.service;

import com.exercise.picture.model.BadComment;
import com.exercise.picture.repository.IBadCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BadCommentService implements IBadCommentService {
    @Autowired
    private IBadCommentRepository badCommentRepository;

    @Override
    public void save(BadComment badComment) {
        badCommentRepository.save(badComment);
    }
}
