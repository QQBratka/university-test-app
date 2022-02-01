package com.example.universitytestproject.dto.request;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class SubjectRequestDto {
    @Size(min = 2, max = 20)
    private String name;
    @Positive
    private int auditory;
    @Positive
    private Long professorId;
}
