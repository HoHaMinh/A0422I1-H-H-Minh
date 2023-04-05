package com.exercise.borrow_book.controller;

import com.exercise.borrow_book.model.Book;
import com.exercise.borrow_book.model.BookBorrow;
import com.exercise.borrow_book.service.IBookBorrowService;
import com.exercise.borrow_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class LibraryController {
    @Autowired
    private IBookBorrowService bookBorrowService;
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showBookList(@RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size,
                               Model model) {
        Integer currentPage = page.orElse(1);
        Integer pageSize = size.orElse(5);
        Page<Book> books = bookService.showAll(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("list", books);
        int totalPages = books.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "list";
    }

    @GetMapping("/showAddBookForm")
    public ModelAndView showAddBookForm() {
        return new ModelAndView("addBookForm", "book", new Book("", 0));
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        bookService.save(book);
        redirectAttributes.addFlashAttribute("msg", "Add Book into library successfully");
        return "redirect:";
    }

    @GetMapping("/borrowBook/{id}")
    public String borrowBook(@PathVariable("id") Integer bookId, RedirectAttributes redirectAttributes) {
        if (bookService.showById(bookId).getBookQuantity() == 0) {
            redirectAttributes.addFlashAttribute("msg", "Can not borrow book because quantity = 0");
            return "redirect:/";
        }
        Random random = new Random();
        Integer randomId;
        do {
            randomId = random.nextInt((89999) + 1) + 10000;
        } while (bookBorrowService.isExist(randomId));
        bookBorrowService.borrow(new BookBorrow(randomId, bookService.showById(bookId)));
        bookService.decreaseBookQuantity(bookId);
        redirectAttributes.addFlashAttribute("msg",
                "Borrow book successfully. Your borrow id is: " + randomId);
        return "redirect:/";
    }

    @GetMapping("giveBookBack")
    public String giveBookBack(@RequestParam("id") Integer borrowId, RedirectAttributes redirectAttributes) {
        if (bookBorrowService.isExist(borrowId)) {
            bookService.increaseBookQuantity(bookBorrowService.showById(borrowId).getBook().getBookId());
            bookBorrowService.bringBookBack(borrowId);
            redirectAttributes.addFlashAttribute("msg", "Give book back successfully");
            return "redirect:";
        } else {
            redirectAttributes.addFlashAttribute("msg", "Wrong borrow id");
            return "redirect:";
        }
    }
}
