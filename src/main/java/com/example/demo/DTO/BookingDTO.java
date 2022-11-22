package com.example.demo.DTO;

import com.example.demo.model.room;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

public class BookingDTO {
    private Integer id;
    private String title;
    private String description;
    private Timestamp start;
    private Timestamp end;
    private String participants;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private room room;

    public BookingDTO(String title, String description,
                      Timestamp start, Timestamp end, String participants, room room) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.participants = participants;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public room getRoom() {
        return room;
    }

    public void setRoom(room room) {
        this.room = room;
    }
}
