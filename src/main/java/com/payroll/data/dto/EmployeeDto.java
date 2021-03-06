package com.payroll.data.dto;


import lombok.Data;
import javax.validation.constraints.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class EmployeeDto {

    @NotNull(message="firstname must have a value")
    private  String firstName;

    @NotNull(message="lastname must have a value")
    private String lastName;

    @NotNull(message="role cannot be null")
    private String role;
}
