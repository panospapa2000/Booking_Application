package com.example.demo.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    private Integer id;
    private String name;

    public Room(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
