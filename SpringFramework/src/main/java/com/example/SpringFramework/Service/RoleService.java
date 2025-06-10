package com.example.SpringFramework.Service;

import com.example.SpringFramework.Model.Role;
import com.example.SpringFramework.Model.User;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    Role getRoleById(int id);
    void createRole(Role role);
    Role updateRole(Role role);
    void deleteRole (int id);
}
