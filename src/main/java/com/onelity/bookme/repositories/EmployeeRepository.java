package com.onelity.bookme.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onelity.bookme.model.employee;

@Repository
public interface EmployeeRepository extends JpaRepository<employee, Integer> {

}
