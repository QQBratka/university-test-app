package com.example.universitytestproject.dto.mapper;

import com.example.universitytestproject.dto.request.GroupRequestDto;
import com.example.universitytestproject.dto.response.GroupResponseDto;
import com.example.universitytestproject.model.Group;
import com.example.universitytestproject.model.Professor;
import com.example.universitytestproject.model.Schedule;
import com.example.universitytestproject.servise.ScheduleService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GroupMapper implements RequestDtoMapper<GroupRequestDto, Group>,
        ResponseDtoMapper<GroupResponseDto, Group> {
    private final ScheduleService scheduleService;

    @Override
    public Group toModel(GroupRequestDto dto) {
        Group group = new Group();
        group.setSpeciality(dto.getSpeciality());
        List<Schedule> scheduleList = dto.getWeekSchedulesIds().stream()
                .map(scheduleService::get)
                .collect(Collectors.toList());
        group.setWeekSchedule(scheduleList);
        return group;
    }

    @Override
    public GroupResponseDto toDto(Group group) {
        GroupResponseDto dto = new GroupResponseDto();
        dto.setSpeciality(group.getSpeciality());
        List<String> professors = group.getProfessors().stream()
                .map(Professor::getLastName)
                .collect(Collectors.toList());
        dto.setProfessors(professors);
        return dto;
    }
}
