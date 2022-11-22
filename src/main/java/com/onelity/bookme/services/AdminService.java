package com.onelity.bookme.services;
import com.onelity.bookme.model.admin;
import com.onelity.bookme.repositories.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    public List<admin> getAdmins(){
        return adminRepository.findAll();
    }

    public admin getAdminById(Integer id){
        return adminRepository.findById(id).orElse(null);
    }

    public String deleteAdminWithID(Integer id) { adminRepository.deleteById(id); return "Admin " + id + " has been removed!";}

    public admin saveAdmin(admin admin){
        return adminRepository.save(admin);
    }

    public List<admin> saveAllAdmins(List<admin> admins){
        return adminRepository.saveAll(admins);
    }

    public String deleteAllAdmins() {
        adminRepository.deleteAll();
        return "All Admins have been removed!";
    }

}
