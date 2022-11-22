package com.onelity.bookme.controllers;

import com.onelity.bookme.model.admin;
import com.onelity.bookme.services.AdminService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    public List<admin> getAdmins() {
        return adminService.getAdmins();
    }

    public admin getAdminById(Integer id) {
        return adminService.getAdminById(id);
    }

    public admin saveAdmin(admin admin) {
        return adminService.saveAdmin(admin);
    }

    public List<admin> saveAllAdmins(List<admin> admins) {
        return adminService.saveAllAdmins(admins);
    }

    public String deleteAllAdmins() {
       return adminService.deleteAllAdmins();
    }

    public String deleteAdminWithID(Integer id) {
       return adminService.deleteAdminWithID(id);

    }
}


