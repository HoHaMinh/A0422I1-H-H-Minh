package display_picture.service;

import display_picture.bean.Comment;
import display_picture.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    ICommentRepository commentRepository;

    @Override
    public List<Comment> showCommentThisDay() {
        return commentRepository.showCommentThisDay();
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void updateLike(Integer id) {
        commentRepository.updateLike(id);
    }
}
