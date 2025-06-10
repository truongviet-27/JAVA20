package com.example.SpringFramework.Repository.Implement;

import com.example.SpringFramework.Model.User;
import com.example.SpringFramework.Repository.CoreRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserImplement implements CoreRepository<User> {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        String jpql = "select u from User u";
        TypedQuery<User> query = entityManager.createQuery(jpql , User.class);
        return query.getResultList();
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void create(User user) {
        User userNew = new User();
        userNew.setFullName(user.getFullName());
        userNew.setAge(user.getAge());
        userNew.setMark(user.getMark());
        userNew.setAddress(user.getAddress());
        userNew.setRole(user.getRole());

        entityManager.persist(userNew);
    }

    @Override
    public User update(User user) {
        User userDB = entityManager.find(User.class, user.getId());
        userDB.setFullName(user.getFullName());
        userDB.setAge(user.getAge());
        userDB.setAddress(user.getAddress());
        userDB.setMark(user.getMark());
        return entityManager.merge(userDB);
    }

    @Override
    public void delete(int id) {
        User userDB = entityManager.find(User.class, id);
        entityManager.remove(userDB);
    }
}
