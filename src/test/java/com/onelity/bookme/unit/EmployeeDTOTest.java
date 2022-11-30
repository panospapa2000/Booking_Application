package com.onelity.bookme.unit;

import com.onelity.bookme.dto.EmployeeDTO;
import com.onelity.bookme.model.Employee;
import com.onelity.bookme.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmployeeDTOTest {

    @Autowired
    private EmployeeService employeeService;

    private static final String TEST_FIRSTNAME = "testFirstname";
    private static final String TEST_LASTNAME = "testLastname";
    private static final String TEST_EMAIL = "testEmail";

    @Test
    public void employeeEntityConvert(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(TEST_FIRSTNAME);
        employeeDTO.setLastName(TEST_LASTNAME);
        employeeDTO.setEmail(TEST_EMAIL);
        Employee employee = employeeDTO.convertToEntity();
        Assertions.assertEquals(TEST_FIRSTNAME, employee.getFirstName());
        Assertions.assertEquals(TEST_LASTNAME, employee.getLastName());
        Assertions.assertEquals(TEST_EMAIL, employee.getEmail());
    }

    @Test
    public void employeeDTOConvert(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Employee employee = new Employee();
        employee.setFirstName(TEST_FIRSTNAME);
        employee.setLastName(TEST_LASTNAME);
        employee.setEmail(TEST_EMAIL);
        employeeDTO = employeeDTO.convertToDto(employee);
        Assertions.assertEquals(TEST_FIRSTNAME, employeeDTO.getFirstName());
        Assertions.assertEquals(TEST_LASTNAME, employeeDTO.getLastName());
        Assertions.assertEquals(TEST_EMAIL, employeeDTO.getEmail());
    }

}

