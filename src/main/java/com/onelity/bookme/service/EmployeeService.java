package com.onelity.bookme.service;

import com.onelity.bookme.model.Employee;
import com.onelity.bookme.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> saveAllEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
