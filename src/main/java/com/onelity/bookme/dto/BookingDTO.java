package com.onelity.bookme.dto;

import com.onelity.bookme.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingDTO {
    private Integer id;
    private String title;
    private String description;
    private Timestamp start;
    private Timestamp end;
    private String participants;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Room room;
}
