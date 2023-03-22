package Controller;

import Model.Customer;
import Model.CustomerType;
import Model.Temporary;
import Service.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "furamaServlet", value = "/home")
public class FuramaServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    private IEmployeeService employeeService = new EmployeeService();
    private IServiceService service = new ServiceService();
    private IContractService contractService = new ContractService();
    private ICustomerTypeSerivce customerTypeSerivce = new CustomerTypeSerive();
    private ITemporaryService temporaryService = new TemporaryService();
    private List<Customer> temporaryCustomerList = new ArrayList<>();
    private List<Temporary> temporaryList = new ArrayList<>();
    private List<Integer> temporaryPages = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "displayCustomer":
                showCustomers(request, response);
                break;
            case "addCustomer":
                showAddCustomerForm(request,response);
                break;
            case "editCustomer":
                showEditCustomerForm(request,response);
                break;
            case "deleteCustomer":
                deleteCustomer(request,response);
                break;
            case "displayTemporary":
                showTemporary(request,response);
                break;
            case "searchCustomer":
                searchCustomer(request,response);
                break;
            case "searchQueryCustomer":
                searchQueryCustomer(request,response);
                break;
            case "choosePageCustomer":
                choosePageCustomer(request,response);
                break;
            case "choosePageTemporary":
                choosePageTemporary(request,response);
                break;
            default:
                showHome(request, response);
        }
    }

    private void searchQueryCustomer(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");
        String searchService = request.getParameter("searchService");
        temporaryList = temporaryService.search(searchName,searchService);
        List<Temporary> temporaries = new ArrayList<>();
        for (int i = 0; i<5; i++) {
            if (i>=temporaryList.size()) {
                break;
            }
            temporaries.add(temporaryList.get(i));
        }
        int rows = temporaryList.size()/5;
        if ((temporaryList.size()%5)!=0) {
            rows++;
        }
        List<Integer> rowList = new ArrayList<>();
        for (int i=1; i<=rows;i++) {
            rowList.add(i);
        }
        temporaryPages = rowList;
        request.setAttribute("pages",rowList);
        request.setAttribute("temporaries", temporaries);
        request.setAttribute("page", 1);


        List<CustomerType> customerTypeList = customerTypeSerivce.showAll();
        request.setAttribute("customerTypeList", customerTypeList);

        try {
            request.getRequestDispatcher("view/customer/customerQuery.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void choosePageTemporary(HttpServletRequest request, HttpServletResponse response) {
        int choice=0;
        if (request.getParameter("id") != null) {
            choice = Integer.parseInt(request.getParameter("id"));
        } else if (choice<1) {
            choice=1;
        }
        List<Temporary> temporaries = new ArrayList<>();
        for (int i=(choice-1)*5;i<(choice*5); i++) {
            if (i>=temporaryList.size()) {
                break;
            }
            temporaries.add(temporaryList.get(i));
        }
        request.setAttribute("pages",temporaryPages);
        request.setAttribute("temporaries",temporaries);
        request.setAttribute("page", choice);
        try {
            request.getRequestDispatcher("view/customer/customerQuery.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void choosePageCustomer(HttpServletRequest request, HttpServletResponse response) {
        int choice=0;
        if (request.getParameter("id") != null) {
            choice = Integer.parseInt(request.getParameter("id"));
        } else if (choice<1) {
            choice=1;
        }
        List<Customer> customerList = new ArrayList<>();
        for (int i=(choice-1)*5;i<(choice*5); i++) {
            if (i>=temporaryCustomerList.size()) {
                break;
            }
            customerList.add(temporaryCustomerList.get(i));
        }
        request.setAttribute("pages",temporaryPages);
        request.setAttribute("customers",customerList);
        request.setAttribute("page", choice);
        try {
            request.getRequestDispatcher("view/customer/customer.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");
        String searchAddress = request.getParameter("searchAddress");
        int searchTypeId = Integer.parseInt(request.getParameter("typeId"));
        temporaryCustomerList = customerService.search(searchName,searchAddress,searchTypeId);
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i<5; i++) {
            if (i>=temporaryCustomerList.size()) {
                break;
            }
            customerList.add(temporaryCustomerList.get(i));
        }
        int rows = temporaryCustomerList.size()/5;
        if ((temporaryCustomerList.size()%5)!=0) {
            rows++;
        }
        List<Integer> rowList = new ArrayList<>();
        for (int i=1; i<=rows;i++) {
            rowList.add(i);
        }
        temporaryPages = rowList;
        request.setAttribute("pages",rowList);
        request.setAttribute("customers", customerList);
        request.setAttribute("page", 1);


        List<CustomerType> customerTypeList = customerTypeSerivce.showAll();
        request.setAttribute("customerTypeList", customerTypeList);

        try {
            request.getRequestDispatcher("view/customer/customer.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showTemporary(HttpServletRequest request, HttpServletResponse response) {
        temporaryList = temporaryService.showAll();
        List<Temporary> temporaries = new ArrayList<>();
        for (int i = 0; i<5; i++) {
            if (i>=temporaryList.size()) {
                break;
            }
            temporaries.add(temporaryList.get(i));
        }
        int rows = temporaryList.size()/5;
        if ((temporaryList.size()%5)!=0) {
            rows++;
        }
        List<Integer> rowList = new ArrayList<>();
        for (int i=1; i<=rows;i++) {
            rowList.add(i);
        }
        temporaryPages = rowList;
        request.setAttribute("pages",rowList);
        request.setAttribute("temporaries", temporaries);
        request.setAttribute("page", 1);
        try {
            request.getRequestDispatcher("view/customer/customerQuery.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("id"));
        String mess = "";
        if (customerService.delete(idDelete)) {
            mess = "Delete customer successfully";}
        else {mess = "Failed to delete customer";}
        request.setAttribute("mess",mess);
        temporaryCustomerList = customerService.showAll();
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i<5; i++) {
            if (i>=temporaryCustomerList.size()) {
                break;
            }
            customerList.add(temporaryCustomerList.get(i));
        }
        int rows = temporaryCustomerList.size()/5;
        if ((temporaryCustomerList.size()%5)!=0) {
            rows++;
        }
        List<Integer> rowList = new ArrayList<>();
        for (int i=1; i<=rows;i++) {
            rowList.add(i);
        }
        temporaryPages = rowList;
        request.setAttribute("pages",rowList);
        request.setAttribute("customers", customerList);
        request.setAttribute("page", 1);
        try {
            request.getRequestDispatcher("view/customer/customer.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeSerivce.showAll();
        request.setAttribute("customerTypeList", customerTypeList);
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        try {
            request.getRequestDispatcher("view/customer/editCustomer.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAddCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeSerivce.showAll();
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            request.getRequestDispatcher("view/customer/addCustomer.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCustomers(HttpServletRequest request, HttpServletResponse response) {
        temporaryCustomerList = customerService.showAll();
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i<5; i++) {
            if (i>=temporaryCustomerList.size()) {
            break;
            }
            customerList.add(temporaryCustomerList.get(i));
        }
        int rows = temporaryCustomerList.size()/5;
        if ((temporaryCustomerList.size()%5)!=0) {
            rows++;
        }
        List<Integer> rowList = new ArrayList<>();
        for (int i=1; i<=rows;i++) {
            rowList.add(i);
        }
        List<CustomerType> customerTypeList = customerTypeSerivce.showAll();
        temporaryPages = rowList;
        request.setAttribute("pages",rowList);
        request.setAttribute("customers", customerList);
        request.setAttribute("page", 1);
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            request.getRequestDispatcher("view/customer/customer.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/home.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addCustomer":
                addCustomer(request,response);
                break;
            case "editCustomer":
                editCustomer(request,response);
                break;
            default:
                showHome(request, response);
    }
}
    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        String mess = "";
        int id = Integer.parseInt(request.getParameter("id"));
        int typeId= Integer.parseInt(request.getParameter("typeId"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id,typeId,name,birthday,gender,idCard,phone,email,address);
        if (customerService.update(customer)) {
            mess = "Edit customer successfully";}
        else {mess = "Failed to edit customer";}
        request.setAttribute("mess",mess);
        temporaryCustomerList = customerService.showAll();
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i<5; i++) {
            if (i>=temporaryCustomerList.size()) {
                break;
            }
            customerList.add(temporaryCustomerList.get(i));
        }
        int rows = temporaryCustomerList.size()/5;
        if ((temporaryCustomerList.size()%5)!=0) {
            rows++;
        }
        List<Integer> rowList = new ArrayList<>();
        for (int i=1; i<=rows;i++) {
            rowList.add(i);
        }
        temporaryPages = rowList;
        request.setAttribute("pages",rowList);
        request.setAttribute("customers", customerList);
        request.setAttribute("page", 1);
        try {
            request.getRequestDispatcher("view/customer/customer.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        int typeId= Integer.parseInt(request.getParameter("typeId"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(typeId,name,birthday,gender,idCard,phone,email,address);
        Map<String, String> errorMap = customerService.add(customer);
        String mess = "Add new customer successfully";
        if (!errorMap.isEmpty()) {
            request.setAttribute("name",name);
            request.setAttribute("gender",gender);
            request.setAttribute("birthday",birthday);
            request.setAttribute("idCard",idCard);
            request.setAttribute("phone",phone);
            request.setAttribute("email",email);
            request.setAttribute("errorMap", errorMap);
            mess = "Failed to add new customer";
        }
        request.setAttribute("mess",mess);
        List<CustomerType> customerTypeList = customerTypeSerivce.showAll();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/addCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}