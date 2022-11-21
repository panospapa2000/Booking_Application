package com.example.demo.services;

import com.example.demo.model.employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public List<employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    public employee saveEmployee(employee employee){
        return employeeRepository.save(employee);
    }

    public List<employee> saveAllEmployees(List<employee> employees){
        return employeeRepository.saveAll(employees);
    }
}
