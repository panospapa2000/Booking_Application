package com.onelity.bookme.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String email;
}
