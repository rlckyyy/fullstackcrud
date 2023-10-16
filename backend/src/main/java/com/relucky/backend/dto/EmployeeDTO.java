package com.relucky.backend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Builder
public class EmployeeDTO {
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private Integer salary;
}
