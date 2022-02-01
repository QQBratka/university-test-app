package com.example.universitytestproject.dto.mapper;

import com.example.universitytestproject.dto.request.ProfessorRequestDto;
import com.example.universitytestproject.dto.response.ProfessorResponseDto;
import com.example.universitytestproject.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper implements RequestDtoMapper<ProfessorRequestDto, Professor>,
        ResponseDtoMapper<ProfessorResponseDto, Professor> {
    @Override
    public Professor toModel(ProfessorRequestDto dto) {
        Professor professor = new Professor();
        professor.setLastName(dto.getLastName());
        professor.setAge(dto.getAge());
        professor.setExperience(dto.getExperience());
        return professor;
    }

    @Override
    public ProfessorResponseDto toDto(Professor professor) {
        ProfessorResponseDto dto = new ProfessorResponseDto();
        dto.setLastName(professor.getLastName());
        dto.setAge(professor.getAge());
        dto.setExperience(professor.getExperience());
        return dto;
    }
}
