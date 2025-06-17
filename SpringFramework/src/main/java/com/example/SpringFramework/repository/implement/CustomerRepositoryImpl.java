package com.example.SpringFramework.repository.implement;

import com.example.SpringFramework.model.Customer;
import com.example.SpringFramework.repository.CoreRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CoreRepository<Customer> {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> getAll() {
        String jpql = "select c from Customer c";
        TypedQuery<Customer> query = entityManager.createQuery(jpql , Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer getById(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void create(Customer user) {
        Customer userNew = new Customer();
        userNew.setName(user.getName());
        userNew.setGender(user.getGender());
        userNew.setBirthdate(user.getBirthdate());
        userNew.setAddress(user.getAddress());
        userNew.setRole(user.getRole());

        entityManager.persist(userNew);
    }

    @Override
    public Customer update(Customer user) {
        Customer userDB = entityManager.find(Customer.class, user.getId());
        userDB.setName(user.getName());
        userDB.setGender(user.getGender());
        userDB.setAddress(user.getAddress());
        userDB.setBirthdate(user.getBirthdate());
        return entityManager.merge(userDB);
    }

    @Override
    public void delete(int id) {
        Customer userDB = entityManager.find(Customer.class, id);
        entityManager.remove(userDB);
    }

    @Override
    public Customer getByCode(String code) {
        return null;
    }
}
