package controller;

import model.RentHouse;
import service.IRentHouseService;
import service.RentHouseService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "exam2", value = "/home")
public class Exam2 extends HttpServlet {
    private IRentHouseService rentHouseService = new RentHouseService();
    private List<RentHouse> temporaryRentHouseList = new ArrayList<>();
    private List<Integer> temporaryPages = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "displayList":
                showList(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
           case "delete":
                delete(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("id"));
        String mess = "";
        if (rentHouseService.delete(idDelete)) {
            mess = "Delete customer successfully";}
        else {mess = "Failed to delete customer";}
        request.setAttribute("mess",mess);
        temporaryRentHouseList = rentHouseService.showAll();
        List<RentHouse> rentHouseList = new ArrayList<>();
        for (int i = 0; i<5; i++) {
            if (i>=temporaryRentHouseList.size()) {
                break;
            }
            rentHouseList.add(temporaryRentHouseList.get(i));
        }
        int rows = temporaryRentHouseList.size()/5;
        if ((temporaryRentHouseList.size()%5)!=0) {
            rows++;
        }
        List<Integer> rowList = new ArrayList<>();
        for (int i=1; i<=rows;i++) {
            rowList.add(i);
        }
        temporaryPages = rowList;
        request.setAttribute("pages",rowList);
        request.setAttribute("list", rentHouseList);
        request.setAttribute("page", 1);
        try {
            request.getRequestDispatcher("view/home.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        List<RentHouse> rentHouseList = rentHouseService.showAll();
        request.setAttribute("list", rentHouseList);
        try {
            request.getRequestDispatcher("view/add.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String searchId = request.getParameter("searchId");
        String searchName = request.getParameter("searchName");
        String searchPhone = request.getParameter("searchPhone");
        temporaryRentHouseList = rentHouseService.search(searchId, searchName, searchPhone);
        List<RentHouse> rentHouseList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i >= temporaryRentHouseList.size()) {
                break;
            }
            rentHouseList.add(temporaryRentHouseList.get(i));
        }
        int rows = temporaryRentHouseList.size() / 5;
        if ((temporaryRentHouseList.size() % 5) != 0) {
            rows++;
        }
        List<Integer> rowList = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            rowList.add(i);
        }
        temporaryPages = rowList;
        request.setAttribute("pages", rowList);
        request.setAttribute("list", rentHouseList);
        request.setAttribute("page", 1);
        try {
            request.getRequestDispatcher("view/home.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        temporaryRentHouseList = rentHouseService.showAll();
        List<RentHouse> rentHouseList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i >= temporaryRentHouseList.size()) {
                break;
            }
            rentHouseList.add(temporaryRentHouseList.get(i));
        }
        int rows = temporaryRentHouseList.size() / 5;
        if ((temporaryRentHouseList.size() % 5) != 0) {
            rows++;
        }
        List<Integer> rowList = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            rowList.add(i);
        }
        temporaryPages = rowList;
        request.setAttribute("pages", rowList);
        request.setAttribute("list", rentHouseList);
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
            case "add":
                add (request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String startDate = request.getParameter("startDate");
        String paymentType = request.getParameter("paymentType");
        String note = request.getParameter("note");
        RentHouse rentHouse = new RentHouse(name,phone,startDate,paymentType,note);
        List<RentHouse> rentHouseList = new ArrayList<>();

        String mess = "";
        if (rentHouseService.add(rentHouse)) {
            mess = "Add new customer successfully";
        }
        request.setAttribute("mess",mess);
        rentHouseList = rentHouseService.showAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/add.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}