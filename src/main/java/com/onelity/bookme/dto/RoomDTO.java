package com.onelity.bookme.dto;
import com.onelity.bookme.model.Booking;
import com.onelity.bookme.model.Room;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.expression.ParseException;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomDTO {
    private Integer id;
    private String name;
    List<Booking> bookings;
    ModelMapper modelMapper = new ModelMapper();

    public RoomDTO convertToDto(Room room) {
        return modelMapper.map(room, RoomDTO.class);
    }

    public Room convertToEntity() throws ParseException {
        return modelMapper.map(this, Room.class);
    }
}
