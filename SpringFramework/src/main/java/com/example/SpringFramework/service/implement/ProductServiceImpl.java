package com.example.SpringFramework.service.implement;

import com.example.SpringFramework.model.Product;
import com.example.SpringFramework.repository.CoreRepository;
import com.example.SpringFramework.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private CoreRepository<Product> productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.create(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.update(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.delete(id);
    }
}
