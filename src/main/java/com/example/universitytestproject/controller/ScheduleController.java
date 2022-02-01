package com.example.universitytestproject.controller;

import com.example.universitytestproject.dto.mapper.ScheduleMapper;
import com.example.universitytestproject.dto.request.ScheduleRequestDto;
import com.example.universitytestproject.dto.response.ScheduleResponseDto;
import com.example.universitytestproject.model.Schedule;
import com.example.universitytestproject.servise.ScheduleService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@AllArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final ScheduleMapper scheduleMapper;

    @PostMapping
    public ScheduleResponseDto create(@RequestBody @Valid ScheduleRequestDto dto) {
        return scheduleMapper.toDto(scheduleService.create(scheduleMapper.toModel(dto)));
    }

    @GetMapping("/get/{id}")
    public ScheduleResponseDto get(@PathVariable Long id) {
        return scheduleMapper.toDto(scheduleService.get(id));
    }

    @GetMapping("/get")
    public List<ScheduleResponseDto> getAll() {
        return scheduleService.getAll().stream()
                .map(scheduleMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public ScheduleResponseDto update(@PathVariable Long id,
                                      @RequestBody @Valid ScheduleRequestDto dto) {
        Schedule schedule = scheduleMapper.toModel(dto);
        schedule.setId(id);
        return scheduleMapper.toDto(scheduleService.create(schedule));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.delete(id);
    }
}
