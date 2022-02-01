package com.example.universitytestproject.dto.response;

import com.example.universitytestproject.model.Speciality;
import lombok.Data;

@Data
public class StudentResponseDto {
    private String firstName;
    private String lastName;
    private int age;
    private int course;
    private Speciality group;
}
