package com.example.SpringFramework.Service.Implement;

import com.example.SpringFramework.Model.Role;
import com.example.SpringFramework.Model.User;
import com.example.SpringFramework.Repository.CoreRepository;
import com.example.SpringFramework.Service.RoleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Log4j2
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private CoreRepository<Role> roleRepository;


    @Override
    public List<Role> getAllRole() {
        return roleRepository.getAll();
    }

    @Override
    public Role getRoleById(int id) {
        Role roleDB = roleRepository.getById(id);
        if (roleDB != null) {
            log.info("Lấy role có id = " + id + " thành công!");
            return roleDB;

        } else {
            return null;
        }
    }

    @Override
    public void createRole(Role role) {
        roleRepository.create(role);
        log.info("Thêm mới user thành công!");
    }

    @Override
    public Role updateRole(Role role) {
        log.info(role.getId());
        Role roleDB = roleRepository.getById(role.getId());
        log.info(roleDB);
        if (roleDB != null) {
            log.info("Update user thành công!");
            return roleRepository.update(role);
        } else {
            log.error("User không tồn tại!");
            return null;
        }
    }

    @Override
    public void deleteRole(int id) {
        Role roleDB = getRoleById(id);
        if (roleDB != null) {
            roleRepository.delete(id);
            log.info("Xóa user thành công!");
        } else {
            log.error("User không tồn tại!");
        }

    }
}
