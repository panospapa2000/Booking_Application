package com.onelity.bookme.integration;
import com.onelity.bookme.model.Admin;
import com.onelity.bookme.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;
    private static final String TEST_USERNAME1 = "testUsername1";
    private static final String TEST_PASSWORD1 = "testPassword1";
    private static final String TEST_USERNAME2 = "testUsername2";
    private static final String TEST_PASSWORD2 = "testPassword2";

    @Test
    public void adminCRUD_positive_size() {
        List<Admin> OG_admins = adminService.getAdmins();
        Admin admin = new Admin();
        admin.setUsername(TEST_USERNAME1);
        admin.setPassword(TEST_PASSWORD1);
        adminService.saveAdmin(admin);
        List<Admin> storedAdmins = adminService.getAdmins();
        Assertions.assertEquals(OG_admins.size() + 1 , storedAdmins.size());
        adminService.deleteAdminWithID(admin.getId());
        List<Admin> storedAdminsFinal = adminService.getAdmins();
        Assertions.assertEquals(OG_admins.size(),storedAdminsFinal.size());
    }

    @Test
    public void adminCRUD_positive_credentials(){
        Admin admin = new Admin();
        admin.setUsername(TEST_USERNAME1);
        admin.setPassword(TEST_PASSWORD1);
        adminService.saveAdmin(admin);
        Optional<Admin> storedAdmin = adminService.getAdminById(admin.getId());
        Assertions.assertTrue(storedAdmin.isPresent());
        Assertions.assertEquals(admin.getUsername(), storedAdmin.get().getUsername());
        Assertions.assertEquals(admin.getPassword(), storedAdmin.get().getPassword());
        adminService.deleteAdminWithID(storedAdmin.get().getId());
        Optional<Admin> storedAdminFinal = adminService.getAdminById(admin.getId());
        Assertions.assertTrue(storedAdminFinal.isEmpty());
    }

    @Test
    public void adminCRUD_negative_usernameNull(){
        Admin admin = new Admin();
        admin.setUsername(null);
        admin.setPassword("randomPassword");
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> adminService.saveAdmin(admin));
    }

    @Test
    public void adminCRUD_negative_passwordNull(){
        Admin admin = new Admin();
        admin.setUsername("randomUsername");
        admin.setPassword(null);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> adminService.saveAdmin(admin));
    }

    @Test
    public void adminCRUD_delete(){
        List<Admin> OG_Admins = adminService.getAdmins();
        adminService.deleteAllAdmins();
        List<Admin> adminsDeleted = adminService.getAdmins();
        Assertions.assertEquals(0 , adminsDeleted.size());
        adminService.saveAllAdmins(OG_Admins);
    }

    @Test
    public void adminCRUD_deleteById(){
        Admin admin = new Admin();
        admin.setUsername(TEST_USERNAME2);
        admin.setPassword(TEST_PASSWORD2);
        adminService.saveAdmin(admin);
        Optional<Admin> storedAdmin = adminService.getAdminById(admin.getId());
        adminService.deleteAdminWithID(storedAdmin.get().getId());
        Optional<Admin> testAdmin = adminService.getAdminById(admin.getId());
        Assertions.assertNotEquals(storedAdmin, testAdmin);
    }
}
