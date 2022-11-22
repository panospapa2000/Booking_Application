package com.onelity.bookme.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee extends JpaRepository<Employee,Integer> {
}
