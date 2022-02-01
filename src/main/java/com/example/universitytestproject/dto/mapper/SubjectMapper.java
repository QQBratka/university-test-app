package com.example.universitytestproject.dto.mapper;

import com.example.universitytestproject.dto.request.SubjectRequestDto;
import com.example.universitytestproject.dto.response.SubjectResponseDto;
import com.example.universitytestproject.model.Subject;
import com.example.universitytestproject.servise.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SubjectMapper implements RequestDtoMapper<SubjectRequestDto, Subject>,
        ResponseDtoMapper<SubjectResponseDto, Subject> {
    private final ProfessorService professorService;

    @Override
    public Subject toModel(SubjectRequestDto dto) {
        Subject subject = new Subject();
        subject.setName(dto.getName());
        subject.setAuditory(dto.getAuditory());
        subject.setProfessor(professorService.get(dto.getProfessorId()));
        return subject;
    }

    @Override
    public SubjectResponseDto toDto(Subject subject) {
        SubjectResponseDto dto = new SubjectResponseDto();
        dto.setName(subject.getName());
        dto.setAuditory(subject.getAuditory());
        dto.setProfessor(subject.getProfessor().getLastName());
        return dto;
    }
}
