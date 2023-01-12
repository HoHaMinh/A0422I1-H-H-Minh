package com.exercise.picture.controller;

import com.exercise.picture.model.BadComment;
import com.exercise.picture.model.Comment;
import com.exercise.picture.service.IBadCommentService;
import com.exercise.picture.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @Autowired
    private IBadCommentService badCommentService;

    @GetMapping("")
    public String showPic (Model model) {
        Date date = new Date();
        model.addAttribute("comment", new Comment(null,"","",date,0));
        model.addAttribute("list",commentService.showCommentThisDay());
        return "home";
    }

    @PostMapping("/comment")
    public String save(@ModelAttribute("comment")Comment comment, RedirectAttributes redirectAttributes) {
        List<String> badWords = Arrays.asList("fuck","bitch");
        for (String s: badWords
             ) {
            if (comment.getFeedback().contains(s)) {
                badCommentService.save(new BadComment(comment.getAuthor(),comment.getFeedback(),comment.getDateComment()));
                redirectAttributes.addFlashAttribute("msg","Comment can not contain bad word: " + s);
                return "redirect:/";
            }
        }
        commentService.save(comment);
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String like (@PathVariable("id") Integer id) {
        commentService.updateLike(id);
        return "redirect:/";
    }
}
