package com.exercise.blog.controller;

import com.exercise.blog.model.Blog;
import com.exercise.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView showList() {
        return new ModelAndView("list", "list", blogService.showAll());
    }

    @GetMapping("/showCreateForm")
    public ModelAndView showCreateForm() {
        return new ModelAndView("createForm", "blog", new Blog("", ""));
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Create successfully");
        return "redirect:";
    }

    @GetMapping("/showEditForm/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
        return new ModelAndView("editForm", "blog", blogService.showById(id));
    }

    @GetMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Edit successfully");
        return "redirect:";
    }

    @GetMapping("/showBlog/{id}")
    public ModelAndView showBlog(@PathVariable("id") Integer id) {
        return new ModelAndView("detail", "blog", blogService.showById(id));
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully");
        return "redirect:/";
    }
}
