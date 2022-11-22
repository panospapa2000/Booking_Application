package com.onelity.bookme.repositories;
import com.onelity.bookme.model.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<admin, Integer> {

}
