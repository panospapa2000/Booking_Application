package com.onelity.bookme.dto;


import com.onelity.bookme.model.Room;

import javax.persistence.ManyToOne;
import java.sql.Timestamp;

    public class BookingDTO {
        private Integer id;
        private String title;
        private String description;
        private Timestamp start_timestamp;
        private Timestamp end_timestamp;
        private String participants;

        @ManyToOne(optional = false)
        Room room;

    public BookingDTO(String title, String description,
                      Timestamp start_timestamp, Timestamp end_timestamp, String participants, Room room) {
        this.title = title;
        this.description = description;
        this.start_timestamp = start_timestamp;
        this.end_timestamp = end_timestamp;
        this.participants = participants;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStart() {
        return start_timestamp;
    }

    public void setStart(Timestamp start_timestamp) {
        this.start_timestamp = start_timestamp;
    }

    public Timestamp getEnd() {
        return end_timestamp;
    }

    public void setEnd(Timestamp end_timestamp) {
        this.end_timestamp = end_timestamp;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
