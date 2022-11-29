package com.onelity.bookme.dto;
import com.onelity.bookme.model.Booking;
import com.onelity.bookme.model.Room;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.expression.ParseException;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
    private Room room;

    ModelMapper modelMapper = new ModelMapper();

    public BookingDTO convertToDto(Booking booking) {
        return modelMapper.map(booking, BookingDTO.class);
    }

    public static void main(String args[]){
        String htmlDate = "2022-11-28T16:07";
        LocalDateTime javaDate = LocalDateTime.parse(htmlDate);
        System.out.println(javaDate);
    }

    public Booking convertToEntity() throws ParseException {
        Booking booking = new Booking();
        booking.setParticipants(this.getParticipants());
        booking.setTitle(this.getTitle());
        booking.setId(this.getId());
        booking.setDescription(this.getDescription());
        booking.setStart_timestamp(Timestamp.valueOf(start_timestamp.toLocalDateTime()));
        booking.setEnd_timestamp(Timestamp.valueOf(end_timestamp.toLocalDateTime()));
        booking.setRoom(this.getRoom());
        return booking;
    }
}
