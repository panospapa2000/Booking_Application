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

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable(value = "id") Integer id) {
        return employeeService.getEmployeeById(id);
    }
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody EmployeeDTO employeeDto) {
        Employee employee = employeeDto.convertToEntity();
        return employeeService.saveEmployee(employee);
    }
    @PostMapping("/employeesList")
    public List<Employee> saveAllEmployees(@RequestBody List<Employee> employees) {
        return employeeService.saveAllEmployees(employees);
    }

    @DeleteMapping("/employees")
    public void deleteAllEmployees(){
        employeeService.deleteAllEmployees();
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Integer id) {
        employeeService.deleteEmployee(id);
    }

}
