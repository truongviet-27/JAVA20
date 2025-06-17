package com.example.SpringFramework.service;

import com.example.SpringFramework.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer getCustomerById(int id);
    void createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer (int id);


}
