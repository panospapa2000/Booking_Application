package com.onelity.bookme.controller;

import com.onelity.bookme.dto.AdminDTO;
import com.onelity.bookme.model.Admin;
import com.onelity.bookme.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admins")
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    public Optional<Admin> getAdminById(Integer id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/admins")
    public Admin saveAdmin(@RequestBody AdminDTO adminDto, @RequestParam String custom_key) {
        Admin admin = adminDto.convertToEntity();
        return adminService.saveAdmin(admin);
    }

    public List<Admin> saveAllAdmins(List<Admin> admins) {
        return adminService.saveAllAdmins(admins);
    }

    public void deleteAdminWithID(Integer id) {
       adminService.deleteAdminWithID(id);
    }

    public void deleteAllAdmins() { adminService.deleteAllAdmins();}


}


