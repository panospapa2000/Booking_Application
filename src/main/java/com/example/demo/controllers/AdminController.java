package com.example.demo.controllers;

import com.example.demo.model.admin;
import com.example.demo.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    private final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    public List<admin> getAdmins() {
        return adminService.getAdmins();
    }
    public admin getAdminById(int id) {
        return adminService.getAdminById(id);
    }
    public admin saveAdmin(admin admin) {
        return adminService.saveAdmin(admin);
    }

    public List<admin> saveAllAdmins(List<admin> admins) {
        return adminService.saveAllAdmins(admins);
    }
}
