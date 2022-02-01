package com.example.universitytestproject.controller;

import com.example.universitytestproject.dto.mapper.StudentMapper;
import com.example.universitytestproject.dto.request.StudentRequestDto;
import com.example.universitytestproject.dto.response.StudentResponseDto;
import com.example.universitytestproject.model.Student;
import com.example.universitytestproject.servise.StudentService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    public StudentResponseDto create(@RequestBody @Valid StudentRequestDto dto) {
        return studentMapper.toDto(studentService.create(studentMapper.toModel(dto)));
    }

    @GetMapping("/get/{id}")
    public StudentResponseDto get(@PathVariable Long id) {
        return studentMapper.toDto(studentService.get(id));
    }

    @GetMapping("/get")
    public List<StudentResponseDto> getAll() {
        return studentService.getAll().stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public StudentResponseDto update(@PathVariable Long id,
                                     @RequestBody @Valid StudentRequestDto dto) {
        Student student = studentMapper.toModel(dto);
        student.setId(id);
        return studentMapper.toDto(studentService.create(student));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    @GetMapping("/{id}")
    public List<String> getByStudentIdAndScheduleDay(@PathVariable Long id,
                                                     @RequestParam String day) {
        return studentService.findByIdAndScheduleDay(id, day);
    }
}
