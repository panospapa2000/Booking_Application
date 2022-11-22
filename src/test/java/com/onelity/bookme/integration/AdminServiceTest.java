package com.onelity.bookme.integration;

import com.onelity.bookme.models.Admin;
import com.onelity.bookme.services.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;
    private static final String TEST_USERNAME = "testUsername";
    private static final String TEST_PASSWORD = "testPassword";

    @Test
    public void adminCRUD_positive() {
        Admin admin = new Admin();
        admin.setUsername(TEST_USERNAME);
        admin.setPassword(TEST_PASSWORD);
        adminService.saveAdmin(admin);
        List<Admin> storedAdmins = adminService.getAdmins();
        Assertions.assertEquals(1, storedAdmins.size());
        Assertions.assertEquals(admin.getUsername(), storedAdmins.get(0).getUsername());
        Assertions.assertEquals(admin.getPassword(), storedAdmins.get(0).getPassword());
        adminService.deleteAllAdmins();
        storedAdmins = adminService.getAdmins();
        Assertions.assertEquals(0, storedAdmins.size());
    }

    @Test
    public void adminCRUD_negative_userNameNull() throws InterruptedException {
        Admin admin = new Admin();
        admin.setUsername(null);
        admin.setPassword("asd");
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> adminService.saveAdmin(admin));
    }

    @Test
    public void testDeleteAllAdmins(){
        adminService.deleteAllAdmins();
        System.out.println("All admins were removed!!!");
    }
}
