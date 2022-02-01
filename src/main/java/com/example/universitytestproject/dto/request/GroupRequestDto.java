package com.example.universitytestproject.dto.request;

import com.example.universitytestproject.model.Speciality;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class GroupRequestDto {
    @NotNull
    private Speciality speciality;
    @NotNull
    @Positive
    private List<Long> professorsIds;
    @NotNull
    @Positive
    private List<Long> weekSchedulesIds;
}
