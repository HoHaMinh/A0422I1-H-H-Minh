package com.example.exam;

import Model.Book;
import Model.Student;
import Service.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "examServlet", value = "/home")
public class ExamServlet extends HttpServlet {
    private IBookService bookService = new BookService();
    private IBorrowService borrowService = new BorrowService();
    private IStudentService studentService = new StudentService();
    private List<Book> temporaryBookList = new ArrayList<>();
//    private List<Temporary> temporaryList = new ArrayList<>();
    private List<Integer> temporaryPages = new ArrayList<>();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "displayBook":
                showBooks(request, response);
                break;
            case "borrow":
                showFormBorrow(request,response);
                break;
//            case "displayTemporary":
//                showTemporary(request,response);
//                break;
//            case "searchCustomer":
//                searchCustomer(request,response);
//                break;
//            case "searchQueryCustomer":
//                searchQueryCustomer(request,response);
//                break;
//            case "choosePageCustomer":
//                choosePageCustomer(request,response);
//                break;
//            case "choosePageTemporary":
//                choosePageTemporary(request,response);
//                break;
            default:
                showBooks(request, response);
        }
    }

    private void showFormBorrow(HttpServletRequest request, HttpServletResponse response) {
        List<Book> bookList = bookService.showAll();
        request.setAttribute("books", bookList);
        List<Student> studentList = studentService.showAll();
        request.setAttribute("students",studentList);
        Date now = new Date();
        request.setAttribute("now",now);
        try {
            request.getRequestDispatcher("view/borrow.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showBooks(HttpServletRequest request, HttpServletResponse response) {
        temporaryBookList = bookService.showAll();
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i<5; i++) {
            if (i>=temporaryBookList.size()) {
                break;
            }
            bookList.add(temporaryBookList.get(i));
        }
        int rows = temporaryBookList.size()/5;
        if ((temporaryBookList.size()%5)!=0) {
            rows++;
        }
        List<Integer> rowList = new ArrayList<>();
        for (int i=1; i<=rows;i++) {
            rowList.add(i);
        }
        temporaryPages = rowList;
        request.setAttribute("pages",rowList);
        request.setAttribute("books", bookList);
        request.setAttribute("page", 1);
        try {
            request.getRequestDispatcher("view/home.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "displayBook":
                showBooks(request, response);
                break;
            case "borrow":
                borow(request, response);
                break;
            default:
                showBooks(request, response);
        }
    }

    private void borow(HttpServletRequest request, HttpServletResponse response) {
        String bookName = request.getParameter("book");
        temporaryBookList = bookService.borrow(bookName);
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i<5; i++) {
            if (i>=temporaryBookList.size()) {
                break;
            }
            bookList.add(temporaryBookList.get(i));
        }
        int rows = temporaryBookList.size()/5;
        if ((temporaryBookList.size()%5)!=0) {
            rows++;
        }
        List<Integer> rowList = new ArrayList<>();
        for (int i=1; i<=rows;i++) {
            rowList.add(i);
        }
        temporaryPages = rowList;
        request.setAttribute("pages",rowList);
        request.setAttribute("books", bookList);
        request.setAttribute("page", 1);
        try {
            request.getRequestDispatcher("view/home.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}