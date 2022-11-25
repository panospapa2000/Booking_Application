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

    @GetMapping("/admins/{id}")
    public Optional<Admin> getAdminById(@PathVariable(value = "id") Integer id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/admins")
    public Admin saveAdmin(@RequestBody AdminDTO adminDto) {
        Admin admin = adminDto.convertToEntity();
        return adminService.saveAdmin(admin);
    }
   // @PostMapping("/admin")
    public List<Admin> saveAllAdmins(List<Admin> admins) {
        return adminService.saveAllAdmins(admins);
    }

    @DeleteMapping("/admins/{id}")
    public void deleteAdminWithID(@PathVariable(value = "id") Integer id) {
       adminService.deleteAdminWithID(id);
    }

    @DeleteMapping("/admins")
    public void deleteAllAdmins() { adminService.deleteAllAdmins();}

}


