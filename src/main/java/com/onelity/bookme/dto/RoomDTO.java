package com.onelity.bookme.dto;
import com.onelity.bookme.model.Room;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.expression.ParseException;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomDTO {
    private Integer id;
    private String name;

    ModelMapper modelMapper = new ModelMapper();

    public RoomDTO convertToDto(Room room) {
        return modelMapper.map(room, RoomDTO.class);
    }

    public Room convertToEntity() throws ParseException {
        return modelMapper.map(this, Room.class);
    }
}
