package com.onelity.bookme.unit;

import com.onelity.bookme.dto.AdminDTO;
import com.onelity.bookme.model.Admin;
import com.onelity.bookme.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdminDTOTest {

    @Autowired
    private AdminService adminService;

    private static final String TEST_USERNAME = "testUsername";
    private static final String TEST_PASSWORD = "testPassword";

    @Test
    public void adminEntityConvert(){
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setUsername(TEST_USERNAME);
        adminDTO.setPassword(TEST_PASSWORD);
        Admin admin = adminDTO.convertToEntity();
        Assertions.assertEquals(TEST_USERNAME, admin.getUsername());
        Assertions.assertEquals(TEST_PASSWORD, admin.getPassword());
    }

    @Test
    public void adminDTOConvert(){
        AdminDTO adminDTO = new AdminDTO();
        Admin admin = new Admin();
        admin.setUsername(TEST_USERNAME);
        admin.setPassword(TEST_PASSWORD);
        adminDTO = adminDTO.convertToDto(admin);
        Assertions.assertEquals(TEST_USERNAME, adminDTO.getUsername());
        Assertions.assertEquals(TEST_PASSWORD, adminDTO.getPassword());
    }

}
