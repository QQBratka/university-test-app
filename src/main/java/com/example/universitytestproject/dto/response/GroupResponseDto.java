package com.example.universitytestproject.dto.response;

import com.example.universitytestproject.model.Speciality;
import java.util.List;
import lombok.Data;

@Data
public class GroupResponseDto {
    private Speciality speciality;
    private List<String> professors;
}
