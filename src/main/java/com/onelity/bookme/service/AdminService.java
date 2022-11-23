package com.onelity.bookme.service;

import com.onelity.bookme.model.Admin;
import com.onelity.bookme.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Integer id){
        return adminRepository.findById(id);
    }

    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public List<Admin> saveAllAdmins(List<Admin> admins){
        return adminRepository.saveAll(admins);
    }

    public void deleteAdminWithID(int id){
        adminRepository.deleteById(id);
    }

    public void deleteAllAdmins(){
        adminRepository.deleteAll();
    }
}
