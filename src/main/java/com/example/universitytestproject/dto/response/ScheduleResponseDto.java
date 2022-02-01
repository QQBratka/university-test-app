package com.example.universitytestproject.dto.response;

import com.example.universitytestproject.model.Day;
import java.util.List;

import com.example.universitytestproject.model.Speciality;
import lombok.Data;

@Data
public class ScheduleResponseDto {
    private Day day;
    private Speciality speciality;
    private List<String> subjects;
}
