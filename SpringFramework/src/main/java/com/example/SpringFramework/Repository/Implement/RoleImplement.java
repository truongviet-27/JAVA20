package com.example.SpringFramework.Repository.Implement;

import com.example.SpringFramework.Model.Role;
import com.example.SpringFramework.Model.User;
import com.example.SpringFramework.Repository.CoreRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Repository
public class RoleImplement implements CoreRepository<Role> {
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
        List<User> users = new ArrayList<>();
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
        User userDB = entityManager.find(User.class, id);
        entityManager.remove(userDB);
    }
}
