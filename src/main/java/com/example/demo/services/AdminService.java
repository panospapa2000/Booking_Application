package com.example.demo.services;

import com.example.demo.models.Admin;
import com.example.demo.models.Employee;
import com.example.demo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }

    public Admin getAdminById(int id){
        return adminRepository.findById(id).orElse(null);
    }

    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public List<Admin> saveAllAdmins(List<Admin> admins){
        return adminRepository.saveAll(admins);
    }

}
