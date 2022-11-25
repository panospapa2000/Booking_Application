package com.onelity.bookme.service;

import com.onelity.bookme.model.Admin;
import com.onelity.bookme.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    /**
     * AdminService works as a constructor dependency injection, using AdminRepository.
     * @param adminRepository
     */
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    /**
     * This method returns the list of all admins from the database, via GET request.
     * @return
     */
    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }

    /**
     * This method returns a specific admin, given his unique id.
     * Also returns Optional.Empty if he does not exist.
     * @param id
     * @return
     */
    public Optional<Admin> getAdminById(Integer id){
        return adminRepository.findById(id);
    }

    /**
     * This method is serving a POST request of a specific admin.
     * @param admin
     * @return
     */
    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    /**
     * This method is serving a POST request of a list of admins, saving them to the database.
     * @param admins
     * @return
     */
    public List<Admin> saveAllAdmins(List<Admin> admins){
        return adminRepository.saveAll(admins);
    }

    /**
     * This method is serving a DELETE request of a specific admin, given his id.
     * @param id
     */
    public void deleteAdminWithID(int id){
        adminRepository.deleteById(id);
    }

    /**
     * This method deletes all admins.
     */
    public void deleteAllAdmins(){
        adminRepository.deleteAll();
    }
}
