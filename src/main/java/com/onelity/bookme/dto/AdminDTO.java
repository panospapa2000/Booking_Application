package com.onelity.bookme.dto;
import com.onelity.bookme.model.Admin;
import lombok.*;
import org.springframework.expression.ParseException;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminDTO {
    private String username;
    private String password;
    ModelMapper modelMapper = new ModelMapper();

    private AdminDTO convertToDto(Admin admin) {
        return modelMapper.map(admin, AdminDTO.class);
    }

    private Admin convertToEntity(AdminDTO adminDto) throws ParseException {
        return modelMapper.map(adminDto, Admin.class);
    }
}
