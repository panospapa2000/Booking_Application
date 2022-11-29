package com.onelity.bookme.dto;
import com.onelity.bookme.model.Employee;
import lombok.*;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String email;

    ModelMapper modelMapper = new ModelMapper();

    public EmployeeDTO convertToDto(Employee employee) {
        return modelMapper.map(this, EmployeeDTO.class);
    }

    public Employee convertToEntity() {
        return modelMapper.map(this, Employee.class);
    }
}
