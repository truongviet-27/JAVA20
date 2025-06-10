package com.example.SpringFramework.Service.Implement;

import com.example.SpringFramework.Model.User;
import com.example.SpringFramework.Repository.CoreRepository;
import com.example.SpringFramework.Service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private CoreRepository<User> userRepository;


    @Override
    public List<User> getAllUser() {
        return userRepository.getAll();
    }

    @Override
    public User getUserById(int id) {
        User userDB = userRepository.getById(id);
        if (userDB != null) {
            log.info("Lấy user có id = " + id + " thành công!");
            return userDB;

        } else {
            return null;
        }
    }

    @Override
    public void createUser(User user) {
        userRepository.create(user);
        log.info("Thêm mới user thành công!");
    }

    @Override
    public User updateUser(User user) {
        log.info(user.getId());
        User userDB = userRepository.getById(user.getId());
        log.info(userDB);
        if (userDB != null) {
            log.info("Update user thành công!");
            return userRepository.update(user);
        } else {
            log.error("User không tồn tại!");
            return null;
        }
    }

    @Override
    public void deleteUser(int id) {
        User userDB = getUserById(id);
        if (userDB != null) {
            userRepository.delete(id);
            log.info("Xóa user thành công!");
        } else {
            log.error("User không tồn tại!");
        }

    }
}
