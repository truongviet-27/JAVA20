package com.example.SpringFramework.repository.implement;

import com.example.SpringFramework.model.Role;
import com.example.SpringFramework.model.Customer;
import com.example.SpringFramework.repository.CoreRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements CoreRepository<Role> {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Role> getAll() {
        String jpql = "select r from Role r";
        TypedQuery<Role> query = entityManager.createQuery(jpql , Role.class);
        return query.getResultList();
    }

    @Override
    public Role getById(int id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void create(Role role) {
        Role roleNew = new Role();
        role.setCode(role.getCode());
        role.setName(role.getName());
        List<Customer> users = new ArrayList<>();
        entityManager.persist(roleNew);
    }

    @Override
    public Role update(Role role) {
        Role roleDB = entityManager.find(Role.class, role.getId());
        roleDB.setCode(role.getCode());
        roleDB.setName(role.getName());
        return entityManager.merge(roleDB);
    }

    @Override
    public void delete(int id) {
        Customer userDB = entityManager.find(Customer.class, id);
        entityManager.remove(userDB);
    }

    @Override
    public Role getByCode(String code) {
        String jpql = "SELECT r FROM Role r WHERE r.code = :code";
        Query query = entityManager.createQuery(jpql, Role.class);
        query.setParameter("code" , code);
        return (Role) query.getSingleResult();
    }
}
