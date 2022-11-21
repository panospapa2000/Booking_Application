package com.example.demo.DTO;
import javax.persistence.Column;

public class AdminDTO {
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
