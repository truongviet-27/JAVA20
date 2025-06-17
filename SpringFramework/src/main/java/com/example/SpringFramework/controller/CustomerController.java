package com.example.SpringFramework.controller;

import com.example.SpringFramework.model.Customer;
import com.example.SpringFramework.model.Role;
import com.example.SpringFramework.service.CustomerService;
import com.example.SpringFramework.service.RoleService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private RoleService roleService;

    //    MVC
    @GetMapping("/view/get-all")
    public String getAllCustomer(Model model) {
        List<Customer> customers = customerService.getAllCustomer();
        model.addAttribute("customers", customers);
        return "customer/get-all/index";
    }

    @GetMapping("/view/{id}")
    public String getCustomerById(Model model, @PathVariable int id) {
        Customer customer = customerService.getCustomerById(id);
        List<Role> roles = roleService.getAllRole();
        model.addAttribute("customer", customer);
        model.addAttribute("roles", roles);
        return "customer/detail/index";
    }

    @GetMapping("/view/create")
    public String getCreateCustomer(Model model) {
        List<Role> roles = roleService.getAllRole();
        model.addAttribute("roles", roles);
        return "customer/create/index";
    }

    @PostMapping("/view/create")
    public String createCustomerMVC(@ModelAttribute Customer customer) {
        Role role = roleService.getRoleByCode(customer.getRole().getCode());
        Customer customer1 = new Customer(customer.getName(), customer.getGender(), customer.getAddress(), customer.getBirthdate(), role);
        customerService.createCustomer(customer1);
        return "redirect:/customer/view/get-all";

    }

    @PostMapping("/view/update")
    public String updateCustomerMVC(@ModelAttribute Customer customer) {
        Role role = roleService.getRoleByCode(customer.getRole().getCode());
        Customer customer1 = new Customer(customer.getId(), customer.getName(), customer.getGender(), customer.getAddress(), customer.getBirthdate(), role);
        customerService.updateCustomer(customer1);
        return "redirect:/customer/view/get-all";
    }

    @GetMapping("/view/delete/{id}")
    public String deleteCustomerMVC(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/view/get-all";
    }

    //  RESTful API
    @GetMapping("/get-all")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/create")
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }
}
