package com.example.SpringFramework.Service;

import com.example.SpringFramework.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(int id);
    void createUser(User user);
    User updateUser(User user);
    void deleteUser (int id);


}
