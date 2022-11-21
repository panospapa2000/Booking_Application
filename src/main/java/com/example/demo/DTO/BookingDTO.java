package com.example.demo.DTO;

import javax.persistence.Column;
import java.sql.Timestamp;

public class BookingDTO {
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_timestamp")
    private Timestamp start_timestamp;

    @Column(name = "end_timestamp")
    private Timestamp end_timestamp;

    @Column(name = "participants")
    private String participants;

    @Column(name = "room_id")
    private Integer room_id;

}
