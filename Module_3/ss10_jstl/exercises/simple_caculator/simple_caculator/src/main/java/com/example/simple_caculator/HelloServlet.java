package com.example.simple_caculator;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/caculator")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("view/caculator.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        float first = Float.parseFloat(request.getParameter("first"));
        float second = Float.parseFloat(request.getParameter("second"));
        float result = 0;
        String choice = request.getParameter("caculator");
        try {
            switch (choice) {
                case "addition":
                    result = first + second;
                    break;
                case "subtraction":
                    result = first - second;
                    break;
                case "multiplication":
                    result = first * second;
                    break;
                case "division":
                    if (second != 0) {
                        result = first / second;
                    } else {
                        throw new RuntimeException("Can't divide by zero");
                    }
            }
            writer.println("<html>");
            writer.println("<h1>First operand:: " + first + "</h1>");
            writer.println("<h1>Second operand: " + second + "</h1>");
            writer.println("<h1>Operator: " + choice + "</h1>");
            writer.println("<h1>Result: " + result + "</h1>");
            writer.println("</html>");
        } catch (RuntimeException e) {
            writer.print("<h1>Can't divide by zero</h1>");
        }
    }
}