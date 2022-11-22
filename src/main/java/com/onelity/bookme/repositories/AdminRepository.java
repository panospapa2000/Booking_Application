package com.onelity.bookme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onelity.bookme.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
