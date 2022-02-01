package com.example.universitytestproject.controller;

import com.example.universitytestproject.dto.mapper.ProfessorMapper;
import com.example.universitytestproject.dto.request.ProfessorRequestDto;
import com.example.universitytestproject.dto.response.ProfessorResponseDto;
import com.example.universitytestproject.model.Professor;
import com.example.universitytestproject.servise.ProfessorService;
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
@RequestMapping("/professors")
@AllArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;
    private final ProfessorMapper professorMapper;

    @PostMapping
    public ProfessorResponseDto create(@RequestBody @Valid ProfessorRequestDto dto) {
        return professorMapper.toDto(professorService.create(professorMapper.toModel(dto)));
    }

    @GetMapping("/get/{id}")
    public ProfessorResponseDto get(@PathVariable Long id) {
        return professorMapper.toDto(professorService.get(id));
    }

    @GetMapping("/get")
    public List<ProfessorResponseDto> getAll() {
        return professorService.getAll().stream()
                .map(professorMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public ProfessorResponseDto update(@PathVariable Long id,
                                       @RequestBody @Valid ProfessorRequestDto dto) {
        Professor professor = professorMapper.toModel(dto);
        professor.setId(id);
        return professorMapper.toDto(professorService.create(professor));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        professorService.delete(id);
    }
}
