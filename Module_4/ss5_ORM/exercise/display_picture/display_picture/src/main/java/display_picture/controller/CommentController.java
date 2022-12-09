package display_picture.controller;

import display_picture.bean.Comment;
import display_picture.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class CommentController {
    @Autowired
    ICommentService commentService;

    @GetMapping("")
    public String showPic (Model model) {
        Date date = new Date();
        model.addAttribute("comment", new Comment(null,"","",date,0));
        model.addAttribute("list",commentService.showCommentThisDay());
        return "home";
    }

    @PostMapping("/comment")
    public String save(@ModelAttribute("comment")Comment comment) {
        commentService.save(comment);
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String like (@PathVariable("id") Integer id) {
        commentService.updateLike(id);
        return "redirect:/";
    }
}
