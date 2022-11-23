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

    private AdminDTO convertToDto(Room room) {
        return modelMapper.map(room, AdminDTO.class);
    }

    private Room convertToEntity(RoomDTO adminDto) throws ParseException {
        return modelMapper.map(adminDto, Room.class);
    }
}
