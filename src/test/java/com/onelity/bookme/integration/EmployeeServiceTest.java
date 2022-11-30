package com.onelity.bookme.integration;
import com.onelity.bookme.model.Employee;
import com.onelity.bookme.repository.EmployeeRepository;
import com.onelity.bookme.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmployeeServiceTest {

    @MockBean
    private EmployeeRepository employeeRepository;
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
    public void postRequestMock(){
        Employee employee = new Employee(Mockito.anyInt(), "MockFirstname", "MockLastname", "MockEmail");
        Mockito.when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Assertions.assertNotEquals(Optional.of(employee), null);
    }
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
        employeeService.deleteEmployee(employee.getId());
        List<Employee> storedEmployeesFinal = employeeService.getEmployees();
        Assertions.assertEquals(OG_employees.size(),storedEmployeesFinal.size());
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
        employeeService.deleteEmployee(storedEmployee.get().getId());
        Optional<Employee> storedEmployeeFinal = employeeService.getEmployeeById(employee.getId());
        Assertions.assertTrue(storedEmployeeFinal.isEmpty());
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
    public void employeeCRUD_delete(){
        List<Employee> OG_Employees = employeeService.getEmployees();
        employeeService.deleteAllEmployees();
        List<Employee> employeesDeleted = employeeService.getEmployees();
        Assertions.assertEquals(0, employeesDeleted.size());
        employeeService.saveAllEmployees(OG_Employees);
    }
    @Test
    public void employeeCRUD_deleteById(){
        Employee employee = new Employee();
        employee.setFirstName(TEST_FIRSTNAME3);
        employee.setLastName(TEST_LASTNAME3);
        employee.setEmail(TEST_EMAIL3);
        employeeService.saveEmployee(employee);
        Optional<Employee> storedEmployee = employeeService.getEmployeeById(employee.getId());
        employeeService.deleteEmployee(storedEmployee.get().getId());
        Optional<Employee> testEmpl = employeeService.getEmployeeById(employee.getId());
        Assertions.assertNotEquals(storedEmployee,testEmpl);
    }
}
