package com.example.SpringFramework.controller;

import com.example.SpringFramework.model.Role;
import com.example.SpringFramework.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;


    @GetMapping("/get-all")
    public List<Role> getAllRole() {
        return roleService.getAllRole();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable int id) {
        return roleService.getRoleById(id);
    }

    @PostMapping("/create")
    public void createRole(@RequestBody Role role) {
        roleService.createRole(role);
    }

    @PutMapping("/update")
    public Role updateRole(@RequestBody Role role) {
        return roleService.updateRole(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable int id) {
        roleService.deleteRole(id);
    }
}
