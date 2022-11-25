package com.onelity.bookme.service;

import com.onelity.bookme.model.Employee;
import com.onelity.bookme.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    /**
     * EmployeeService works as a constructor dependency injection, using EmployeeRepository.
     * @param employeeRepository
     */
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    /**
     * This method returns the list of all employees from the database, via GET request.
     * @return
     */
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    /**
     * This method returns a specific employee, given his unique id.
     * Also returns Optional.Empty if he does not exist.
     * @param id
     * @return
     */
    public Optional<Employee> getEmployeeById(int id){
        return employeeRepository.findById(id);
    }

    /**
     * This method is serving a POST request of a specific employee.
     * @param employee
     * @return
     */
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    /**
     * This method is serving a POST request of a list of employees, saving them to the database.
     * @param employees
     * @return
     */
    public List<Employee> saveAllEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }

    /**
     * This method is serving a DELETE request of a specific employee, given his id.
     * @param id
     */
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
