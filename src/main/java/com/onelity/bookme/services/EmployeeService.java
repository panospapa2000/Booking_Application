package com.onelity.bookme.services;

import com.onelity.bookme.model.employee;
import com.onelity.bookme.repositories.EmployeeRepository;
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

    public String deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
        return "employee " + id + " has been removed!";
    }

    public String deleteAllEmployees(){
        employeeRepository.deleteAll();
        return "All employees have been deleted!";
    }
}
