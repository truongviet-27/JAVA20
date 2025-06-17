package com.example.SpringFramework.service.implement;

import com.example.SpringFramework.model.Customer;
import com.example.SpringFramework.repository.CoreRepository;
import com.example.SpringFramework.service.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CoreRepository<Customer> customerRepository;


    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customerDB = customerRepository.getById(id);
        if (customerDB != null) {
            log.info("Lấy customer có id = " + id + " thành công!");
            return customerDB;

        } else {
            return null;
        }
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.create(customer);
        log.info("Thêm mới user thành công!");
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        log.info(customer.getId());
        Customer customerDB = customerRepository.getById(customer.getId());
        log.info(customerDB);
        if (customerDB != null) {
            log.info("Update user thành công!");
            return customerRepository.update(customer);
        } else {
            log.error("User không tồn tại!");
            return null;
        }
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customerDB = getCustomerById(id);
        if (customerDB != null) {
            customerRepository.delete(id);
            log.info("Xóa user thành công!");
        } else {
            log.error("User không tồn tại!");
        }

    }
}
