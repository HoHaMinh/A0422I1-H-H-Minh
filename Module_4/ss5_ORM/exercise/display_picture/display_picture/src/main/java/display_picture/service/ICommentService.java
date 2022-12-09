package display_picture.service;

import display_picture.bean.Comment;


import java.util.List;

public interface ICommentService {
    public List<Comment> showCommentThisDay();
    public void save(Comment comment);

    public void updateLike (Integer id);
}
