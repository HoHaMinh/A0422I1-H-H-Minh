package com.exercise.blog_app_security.controller;

import com.exercise.blog_app_security.model.Blog;
import com.exercise.blog_app_security.model.Category;
import com.exercise.blog_app_security.service.IBlogService;
import com.exercise.blog_app_security.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/home")
    public ModelAndView showUserHome() {
        return new ModelAndView("home", "list", categoryService.showAll());
    }

    @GetMapping("/guest/showListBlogs")
    public String showListBlogs(Model model, @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size,
                                @RequestParam("sort") Optional<String> sort) {
        Integer currentPage = page.orElse(1);
        Integer pageSize = size.orElse(5);
        String sortField = sort.orElse("dateCreate");
        Page<Blog> blogs = blogService.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));
        model.addAttribute("list", blogs);
        int totalPages = blogs.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "blog/list";
    }

    @GetMapping("/guest/showListBlogs/{id}")
    public String showListBlogsByIdCategory(@PathVariable("id") Integer id,
                                            @RequestParam("page") Optional<Integer> page,
                                            @RequestParam("size") Optional<Integer> size,
                                            @RequestParam("sort") Optional<String> sort,
                                            Model model) {
        Integer currentPage = page.orElse(1);
        Integer pageSize = size.orElse(5);
        String sortField = sort.orElse("dateCreate");
        Page<Blog> blogs = blogService.findCategoryWithPaging(id, PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));
        model.addAttribute("list", blogs);
        int totalPages = blogs.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "blog/list";
    }

    @GetMapping("/user/showCreateForm")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog("", "", new Date()));
        model.addAttribute("category", categoryService.showAll());
        return "blog/createForm";
    }

    @PostMapping("/user/create")
    public String create(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Create successfully");
        return "redirect:/guest/showListBlogs";
    }

    @GetMapping("/user/showEditForm/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
        return new ModelAndView("blog/editForm", "blog", blogService.showById(id));
    }

    @PostMapping("/user/edit")
    public String edit(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Edit successfully");
        return "redirect:/guest/showListBlogs";
    }

    @GetMapping("/guest/showBlog/{id}")
    public ModelAndView showBlog(@PathVariable("id") Integer id) {
        return new ModelAndView("blog/detail", "blog", blogService.showById(id));
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully");
        return "redirect:/guest/showListBlogs";
    }

    @GetMapping("/user/showAddCategoryForm")
    public ModelAndView showAddCategoryForm() {
        return new ModelAndView("category/createForm", "category", new Category(""));
    }

    @PostMapping("/user/createCategory")
    public String createCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("msg", "Add category successfully");
        return "redirect:/home";
    }

    @GetMapping("/user/showEditCategoryForm/{id}")
    public ModelAndView showEditCategoryForm(@PathVariable("id") Integer id) {
        return new ModelAndView("category/editForm", "category", categoryService.showById(id));
    }

    @PostMapping("/user/editCategory")
    public String editCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("msg", "Edit category successfully");
        return "redirect:/home";
    }

    @GetMapping("/user/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Delete category successfully");
        return "redirect:/home";
    }
}
