package com.example.demo.DTO;

import javax.persistence.Column;

public class EmployeeDTO {

    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;
}
