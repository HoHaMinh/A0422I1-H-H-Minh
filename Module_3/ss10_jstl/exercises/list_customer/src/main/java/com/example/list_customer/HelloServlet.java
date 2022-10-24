package com.example.list_customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet(name = "customerServlet", urlPatterns = "/customer")
public class HelloServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("Mai Văn Hoàn",new Date("20/08/1983"),"Hà Nội","webapp/views/1.png"));
        customerList.add(new Customer("Nguyễn Văn Nam",new Date("21/08/1983"),"Bắc Giang","webapp/views/2.png"));
        customerList.add(new Customer("Nguyễn Thái Hòa",new Date("22/08/1983"),"Nam Định","webapp/views/3.png"));
        customerList.add(new Customer("Trần Đăng Khoa",new Date("17/08/1983"),"Hà Tây","webapp/views/4.png"));
        customerList.add(new Customer("Nguyễn Đình Thi",new Date("19/08/1983"),"Hà Nội","webapp/views/5.png"));
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("views/list.jsp").forward(request, response);
    }
    public void destroy() {
    }
}