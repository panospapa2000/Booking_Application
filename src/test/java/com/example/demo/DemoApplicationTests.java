package com.example.demo;

import com.example.demo.models.Admin;
import com.example.demo.repositories.AdminRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {



	@Autowired
	AdminRepository adminRepository;

	@Test
	void contextLoads() {
//		Assertions.assertTrue(adminRepository.findAll().isEmpty());
//		Admin admin = new Admin();
//		admin.setPassword("asasd");
//		admin.setUsername("username");
//		adminRepository.save(admin);
//		List<Admin> admins = adminRepository.findAll();
//		Assertions.assertEquals(1, admins.size());
//		Admin storedAdmin = admins.get(0);
//		Assertions.assertEquals(storedAdmin.getUsername(), admin.getUsername());
//		Assertions.assertEquals(storedAdmin.getPassword(), admin.getPassword());
//		adminRepository.deleteById(storedAdmin.getId());
//		Assertions.assertTrue(adminRepository.findAll().isEmpty());

	}

}
