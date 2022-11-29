package com.onelity.bookme.dto;
import com.onelity.bookme.model.Admin;
import lombok.*;
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

    public AdminDTO convertToDto(Admin admin) {
        return modelMapper.map(this, AdminDTO.class);
    }

    public Admin convertToEntity() {
        return modelMapper.map(this, Admin.class);
    }
}
