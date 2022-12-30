package com.practice.customer_manager.controller;

import com.practice.customer_manager.model.Customer;
import com.practice.customer_manager.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> showAllCustomers () {
        List<Customer> customers = customerService.findAll();
        if (customers.isEmpty()) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> showCustomerById (@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if(customer==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer (@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> editCustomer (@PathVariable ("id") Long id, @RequestBody Customer customer) {
        Customer customer1 = customerService.findById(id);
        if (customer1==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customer1.getId());
        return new ResponseEntity<>(customerService.save(customer),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteById (@PathVariable ("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer==null) {
            return "Not found";
        }
        customerService.remove(id);
        return "Successfully delete";
    }
}
