package com.example.product_manager;

import model.Product;
import service.IProductService;
import service.ProductService;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ProductServlet", value = "/servlet")
public class ProductServlet extends HttpServlet {
    private static IProductService productService = new ProductService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "display":
                showListProducts(request, response);
                break;
            case "edit":
                findById(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "find":
                findByName(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                editProduct(request, response);
                showListProducts(request, response);
                break;
        }
    }

    private void showListProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.displayAll();
        request.setAttribute("ProductList", productList);
        try {
            request.getRequestDispatcher("view/display.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Product findById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product productFindByID = productService.findById(id);
        request.setAttribute("ProductFind", productFindByID);
        try {
            request.getRequestDispatcher("view/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productFindByID;
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufacture = request.getParameter("manufacture");
        Product p = new Product(id, name, price, description, manufacture);
        if (productService.edit(p)) {
            showListProducts(request, response);
        }
    }

    private List<Product> findByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("find");
        request.setAttribute("ProductsToFind", productService.findByName(name));
        try {
            request.getRequestDispatcher("view/find.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productService.findByName(name);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        if (productService.delete(id)) {
            showListProducts(request, response);
        } else {
            try {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}