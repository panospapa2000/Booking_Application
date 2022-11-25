package com.onelity.bookme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "start_timestamp", nullable = false)
    private Timestamp start;

    @Column(name = "end_timestamp", nullable = false)
    private Timestamp end;

    @Column(name = "participants", nullable = false)
    private String participants;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
}
