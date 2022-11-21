package com.example.demo.services;
import com.example.demo.model.admin;
import com.example.demo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    public List<admin> getAdmins(){
        return adminRepository.findAll();
    }

    public admin getAdminById(int id){
        return adminRepository.findById(id).orElse(null);
    }

    public admin saveAdmin(admin admin){
        return adminRepository.save(admin);
    }

    public List<admin> saveAllAdmins(List<admin> admins){
        return adminRepository.saveAll(admins);
    }

}
