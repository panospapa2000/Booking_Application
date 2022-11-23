package com.onelity.bookme.dto;


import com.onelity.bookme.model.Room;
import lombok.*;

import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingDTO {
    private Integer id;
    private String title;
    private String description;
    private Timestamp start_timestamp;
    private Timestamp end_timestamp;
    private String participants;

    @ManyToOne(optional = false)
    Room room;
}
