package com.onelity.bookme.dto;
import com.onelity.bookme.model.Booking;
import com.onelity.bookme.model.Room;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.expression.ParseException;

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

    ModelMapper modelMapper = new ModelMapper();

    public BookingDTO convertToDto(Booking booking) {
        return modelMapper.map(booking, BookingDTO.class);
    }

    public Booking convertToEntity() throws ParseException {
        return modelMapper.map(this, Booking.class);
    }
}
