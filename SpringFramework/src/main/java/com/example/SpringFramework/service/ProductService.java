package com.example.SpringFramework.service;

import com.example.SpringFramework.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProductById(int id);
    void createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct (int id);
}
