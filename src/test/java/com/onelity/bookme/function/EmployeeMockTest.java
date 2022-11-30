package com.onelity.bookme.function;

import com.onelity.bookme.model.Employee;
import com.onelity.bookme.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

@SpringBootTest
public class EmployeeMockTest {
    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void postRequestMock(){
        Employee employee = new Employee(Mockito.anyInt(), "MockFirstname", "MockLastname", "MockEmail");
        Mockito.when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Assertions.assertNotEquals(Optional.of(employee), null);
    }
}
