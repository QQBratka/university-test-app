package com.example.universitytestproject.dto.mapper;

import com.example.universitytestproject.dto.request.ScheduleRequestDto;
import com.example.universitytestproject.dto.response.ScheduleResponseDto;
import com.example.universitytestproject.model.Schedule;
import com.example.universitytestproject.model.Subject;
import com.example.universitytestproject.servise.SubjectService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ScheduleMapper implements RequestDtoMapper<ScheduleRequestDto, Schedule>,
        ResponseDtoMapper<ScheduleResponseDto, Schedule> {
    private final SubjectService subjectService;

    @Override
    public Schedule toModel(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule();
        schedule.setDay(dto.getDay());
        schedule.setSpeciality(dto.getSpeciality());
        List<Subject> subjects = dto.getSubjectsIds().stream()
                .map(subjectService::get)
                .collect(Collectors.toList());
        schedule.setSubjects(subjects);
        return schedule;
    }

    @Override
    public ScheduleResponseDto toDto(Schedule schedule) {
        ScheduleResponseDto dto = new ScheduleResponseDto();
        dto.setDay(schedule.getDay());
        dto.setSpeciality(schedule.getSpeciality());
        List<String> subjects = schedule.getSubjects().stream()
                .map(Subject::getName)
                .collect(Collectors.toList());
        dto.setSubjects(subjects);
        return dto;
    }
}
