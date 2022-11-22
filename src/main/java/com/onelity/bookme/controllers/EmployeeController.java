package com.onelity.bookme.controllers;

import com.onelity.bookme.model.employee;
import com.onelity.bookme.services.EmployeeService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) { this.employeeService = employeeService; }

    public List<employee> getEmployees() {
        return employeeService.getEmployees();
    }
    public employee getEmployeeById(Integer id) {
        return employeeService.getEmployeeById(id);
    }
    public employee saveEmployee(employee employee) {
        return employeeService.saveEmployee(employee);
    }
    public List<employee> saveAllEmployees(List<employee> employees) {
        return employeeService.saveAllEmployees(employees);
    }
    public String deleteEmployee(Integer id) {
        return employeeService.deleteEmployee(id);
    }

    public String deleteAllEmployees() {
        return employeeService.deleteAllEmployees();
    }

}
