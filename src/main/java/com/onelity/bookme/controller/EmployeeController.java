package com.onelity.bookme.controller;

import com.onelity.bookme.model.Employee;
import com.onelity.bookme.service.EmployeeService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) { this.employeeService = employeeService; }

    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeService.getEmployeeById(id);
    }
    public Employee saveEmployee(Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    public List<Employee> saveAllEmployees(List<Employee> employees) {
        return employeeService.saveAllEmployees(employees);
    }
    public void deleteAllEmployees(){
        employeeService.deleteAllEmployees();
    }
    public void deleteEmployee(Integer id) {
        employeeService.deleteEmployee(id);
    }

}
