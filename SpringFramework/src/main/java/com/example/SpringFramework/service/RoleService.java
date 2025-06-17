package com.example.SpringFramework.service;

import com.example.SpringFramework.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    Role getRoleById(int id);
    void createRole(Role role);
    Role updateRole(Role role);
    void deleteRole (int id);
    Role getRoleByCode(String code);
}
