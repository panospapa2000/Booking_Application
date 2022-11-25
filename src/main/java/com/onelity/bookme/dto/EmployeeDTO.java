package com.onelity.bookme.dto;
import com.onelity.bookme.model.Employee;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.expression.ParseException;

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
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public Employee convertToEntity() throws ParseException {
        return modelMapper.map(this, Employee.class);
    }
}
