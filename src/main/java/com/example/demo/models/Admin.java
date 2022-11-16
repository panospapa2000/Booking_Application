package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    private Integer id;
    private String username;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//
//    @Override
//    public String toString(){
//        return this.username.concat(" " ).concat(this.password);
//    }
}
