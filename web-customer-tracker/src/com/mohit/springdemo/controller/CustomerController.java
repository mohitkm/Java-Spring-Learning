package com.mohit.springdemo.controller;

import com.mohit.springdemo.dao.CustomerDAO;
import com.mohit.springdemo.dao.CustomerDAOImpl;
import com.mohit.springdemo.entity.Customer;
import com.mohit.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    // inject customer service
    @Autowired
    @Qualifier("customerServiceImpl")
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel){
        // get customers from the service
        List<Customer> customers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", customers);


        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        // create model attribute to bind form data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        // save customer using customer service
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
        Customer theCustomer = customerService.getCustomer(theId);

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){
        // delete the customer
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }
}
