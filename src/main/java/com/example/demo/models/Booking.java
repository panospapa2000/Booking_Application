package com.example.demo.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "booking")
public class Booking {

    private Integer id;
    private String title;
    private String description;
    private Timestamp start;
    private Timestamp end;
    private String participants;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="room_id")
    private Room room;


    public Booking(Integer id, String title, String description, Timestamp start, Timestamp end, String participants, Room room) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.participants = participants;
        this.room = room;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "start_timestamp", nullable = false)
    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    @Column(name = "end_timestamp", nullable = false)
    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    @Column(name = "participants", nullable = false)
    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }
}
