package com.example.universitytestproject.controller;

import com.example.universitytestproject.dto.mapper.SubjectMapper;
import com.example.universitytestproject.dto.request.SubjectRequestDto;
import com.example.universitytestproject.dto.response.SubjectResponseDto;
import com.example.universitytestproject.model.Subject;
import com.example.universitytestproject.servise.SubjectService;
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
@RequestMapping("/subjects")
@AllArgsConstructor
public class    SubjectController {
    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

    @PostMapping
    public SubjectResponseDto create(@RequestBody @Valid SubjectRequestDto dto) {
        return subjectMapper.toDto(subjectService.create(subjectMapper.toModel(dto)));
    }

    @GetMapping("/get/{id}")
    public SubjectResponseDto get(@PathVariable Long id) {
        return subjectMapper.toDto(subjectService.get(id));
    }

    @GetMapping("/get")
    public List<SubjectResponseDto> getAll() {
        return subjectService.getAll().stream()
                .map(subjectMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public SubjectResponseDto update(@PathVariable Long id,
                                     @RequestBody @Valid SubjectRequestDto dto) {
        Subject subject = subjectMapper.toModel(dto);
        subject.setId(id);
        return subjectMapper.toDto(subjectService.create(subject));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subjectService.delete(id);
    }
}
