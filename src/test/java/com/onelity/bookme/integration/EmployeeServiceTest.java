package com.onelity.bookme.integration;


import com.onelity.bookme.models.Employee;
import com.onelity.bookme.services.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;
    private static final String TEST_FIRSTNAME = "testFirstname";
    private static final String TEST_LASTNAME = "testLastname";
    private static final String TEST_EMAIL = "testEmail";

    @Test
    public void employeeCRUD_positive() throws InterruptedException {
        Employee employee = new Employee();
        employee.setFirstName(TEST_FIRSTNAME);
        employee.setLastName(TEST_LASTNAME);
        employee.setEmail(TEST_EMAIL);
        Thread.sleep(1000);
        employeeService.saveEmployee(employee);
        List<Employee> storedEmployees = employeeService.getEmployees();
        Assertions.assertEquals(1, storedEmployees.size());
        Assertions.assertEquals(employee.getFirstName(), storedEmployees.get(0).getFirstName());
        Assertions.assertEquals(employee.getLastName(), storedEmployees.get(0).getLastName());
        Assertions.assertEquals(employee.getEmail(), storedEmployees.get(0).getEmail());
        storedEmployees = employeeService.getEmployees();
        Assertions.assertEquals(1, storedEmployees.size());
    }

    @Test
    public void employee_negative_firstNameNULL(){
        Employee employee = new Employee();
        employee.setFirstName(null);
        employee.setLastName("Papaioannou");
        employee.setEmail("panpap200@gmail.com");
        Assertions.assertThrows(DataIntegrityViolationException.class,
                ()-> employeeService.saveEmployee(employee));
    }
}
