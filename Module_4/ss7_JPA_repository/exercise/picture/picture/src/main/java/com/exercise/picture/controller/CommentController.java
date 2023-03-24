package com.exercise.picture.controller;

import com.exercise.picture.model.Comment;
import com.exercise.picture.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("")
    public String showPic(Model model, @RequestParam("page")Optional<Integer> page,
                          @RequestParam("size") Optional<Integer> size) {
        Integer currentPage = page.orElse(1);
        Integer pageSize = size.orElse(5);
        Page<Comment> pages = commentService.showCommentThisDay(PageRequest.of(currentPage-1,pageSize));
        Date date = new Date();
        model.addAttribute("comment", new Comment(null, "", "", date, 0));
        model.addAttribute("list", pages);
        Integer totalPages = pages.getTotalPages();
        if (totalPages>1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "home";
    }

    @PostMapping("/comment")
    public String save(@ModelAttribute("comment") Comment comment) {
        commentService.save(comment);
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") Integer id) {
        commentService.updateLike(id);
        return "redirect:/";
    }
}
