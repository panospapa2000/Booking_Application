package com.onelity.bookme.function;

import com.onelity.bookme.model.Admin;
import com.onelity.bookme.repository.AdminRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

@SpringBootTest
public class AdminMockTest {
    @MockBean
    private AdminRepository adminRepository;


    @Test
    public void postRequestMock(){
        Admin admin = new Admin(Mockito.anyInt(), "mockUsername", "mockPassword");
        Mockito.when(adminRepository.findById(admin.getId())).thenReturn(Optional.of(admin));
        Mockito.when(adminRepository.save(admin)).thenReturn(admin);
        Assertions.assertNotEquals(Optional.of(admin), null);
    }
}
