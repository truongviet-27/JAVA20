package com.example.SpringFramework.repository.implement;

import com.example.SpringFramework.model.Product;
import com.example.SpringFramework.repository.CoreRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements CoreRepository<Product> {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        String jpql = "select p from Product p";
        TypedQuery<Product> query = entityManager.createQuery(jpql , Product.class);
        return query.getResultList();
    }

    @Override
    public Product getById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void create(Product product) {
        Product productNew = new Product();
        productNew.setName(product.getName());
        productNew.setCode(product.getCode());
        productNew.setPrice(product.getPrice());

        entityManager.persist(productNew);
    }

    @Override
    public Product update(Product product) {
        Product productDB = entityManager.find(Product.class, product.getId());
        productDB.setName(product.getName());
        productDB.setCode(product.getCode());
        productDB.setPrice(product.getPrice());
        return entityManager.merge(productDB);
    }

    @Override
    public void delete(int id) {
        Product productDB = entityManager.find(Product.class, id);
        entityManager.remove(productDB);
    }

    @Override
    public Product getByCode(String code) {
        return null;
    }
}
