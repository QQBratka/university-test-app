package com.example.universitytestproject.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class StudentRequestDto {
    private String firstName;
    private String lastName;
    @Min(value = 16)
    private int age;
    @Positive
    @Max(value = 5)
    private int course;
    @Positive
    private Long groupId;
}
