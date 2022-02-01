package com.example.universitytestproject.dto.request;

import com.example.universitytestproject.model.Day;
import com.example.universitytestproject.model.Speciality;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class ScheduleRequestDto {
    @NotNull
    private Day day;
    @NotNull
    private Speciality speciality;
    @NotNull
    @Positive
    private List<Long> subjectsIds;
}
