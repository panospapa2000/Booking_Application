package com.onelity.bookme.integration;


import com.onelity.bookme.model.Employee;
import com.onelity.bookme.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;
    private static final String TEST_FIRSTNAME1 = "Panagiotis";
    private static final String TEST_LASTNAME1 = "Papaioannou";
    private static final String TEST_EMAIL1 = "panpap2000@gmail.com";

    private static final String TEST_FIRSTNAME2 = "Themis";
    private static final String TEST_LASTNAME2 = "Koukoutzelas";
    private static final String TEST_EMAIL2 = "themkouk@gmail.com";

    private static final String TEST_FIRSTNAME3 = "Savvas";
    private static final String TEST_LASTNAME3 = "Salifoglou";
    private static final String TEST_EMAIL3 = "savsal@gmail.com";

    @Test
    public void employeeCRUD_positive_size() throws InterruptedException {
        List<Employee> OG_employees = employeeService.getEmployees();
        Employee employee = new Employee();
        employee.setFirstName(TEST_FIRSTNAME1);
        employee.setLastName(TEST_LASTNAME1);
        employee.setEmail(TEST_EMAIL1);
        employeeService.saveEmployee(employee);
        List<Employee> storedEmployees = employeeService.getEmployees();
        Assertions.assertEquals(OG_employees.size() + 1, storedEmployees.size());
    }

    @Test
    public void employeeCRUD_positive_credentials(){
        Employee employee = new Employee();
        employee.setFirstName(TEST_FIRSTNAME2);
        employee.setLastName(TEST_LASTNAME2);
        employee.setEmail(TEST_EMAIL2);
        employeeService.saveEmployee(employee);
        Optional<Employee> storedEmployee = employeeService.getEmployeeById(employee.getId());
        Assertions.assertTrue(storedEmployee.isPresent());
        Assertions.assertEquals(employee.getFirstName(), storedEmployee.get().getFirstName());
        Assertions.assertEquals(employee.getLastName(), storedEmployee.get().getLastName());
        Assertions.assertEquals(employee.getEmail(), storedEmployee.get().getEmail());
    }

    @Test
    public void employeeCRUD_negative_firstnameNull(){
        Employee employee = new Employee();
        employee.setFirstName(null);
        employee.setLastName("randomLastname");
        employee.setEmail("randomEmail");
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> employeeService.saveEmployee(employee));
    }

    @Test
    public void employeeCRUD_negative_lastnameNull(){
        Employee employee = new Employee();
        employee.setFirstName("randomFirstname");
        employee.setLastName(null);
        employee.setEmail("randomEmail");
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> employeeService.saveEmployee(employee));
    }

    @Test
    public void employeeCRUD_negative_emailNull(){
        Employee employee = new Employee();
        employee.setFirstName("randomFirstname");
        employee.setLastName("randomLastname");
        employee.setEmail(null);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> employeeService.saveEmployee(employee));
    }

    @Test
    public void employeeCRUD_deleteById(){
        Employee employee = new Employee();
        employee.setFirstName(TEST_FIRSTNAME3);
        employee.setLastName(TEST_LASTNAME3);
        employee.setEmail(TEST_EMAIL3);
        employeeService.saveEmployee(employee);
        Optional<Employee> storedEmployee = employeeService.getEmployeeById(employee.getId());
        employeeService.deleteEmployee(employee.getId());
        List<Employee> newEmployees = employeeService.getEmployees();
        //Assertions.assertEquals(newEmployees.size(), storedEmployee.size() - 1);
    }
}
