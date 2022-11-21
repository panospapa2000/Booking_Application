package com.example.demo.DTO;

import javax.persistence.Column;

public class RoomDTO {

    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
