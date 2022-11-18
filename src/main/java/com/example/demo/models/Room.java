package com.example.demo.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    private Integer id;
    private String name;

    @OneToMany(targetEntity = Booking.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private List<Booking> bookings;

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
