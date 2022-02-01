package com.example.universitytestproject.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ProfessorRequestDto {
    private String lastName;
    @Min(value = 23)
    private int age;
    @PositiveOrZero
    private int experience;
}
