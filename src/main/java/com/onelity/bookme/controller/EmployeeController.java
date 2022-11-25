package com.onelity.bookme.controller;

import com.onelity.bookme.dto.EmployeeDTO;
import com.onelity.bookme.model.Admin;
import com.onelity.bookme.model.Employee;
import com.onelity.bookme.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) { this.employeeService = employeeService; }

    @GetMapping("/employee")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable(value = "id") Integer id) {
        return employeeService.getEmployeeById(id);
    }
    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody EmployeeDTO employeeDto) {
        Employee employee = employeeDto.convertToEntity();
        return employeeService.saveEmployee(employee);
    }
    public List<Employee> saveAllEmployees(List<Employee> employees) {
        return employeeService.saveAllEmployees(employees);
    }
    @DeleteMapping("/employee")
    public void deleteAllEmployees(){
        employeeService.deleteAllEmployees();
    }
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Integer id) {
        employeeService.deleteEmployee(id);
    }

}
