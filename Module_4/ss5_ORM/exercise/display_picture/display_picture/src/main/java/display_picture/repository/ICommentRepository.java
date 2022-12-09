package display_picture.repository;

import display_picture.bean.Comment;

import java.util.List;

public interface ICommentRepository {
    public List<Comment> showCommentThisDay();
    public void save(Comment comment);
    public void updateLike (Integer id);
}
