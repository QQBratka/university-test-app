package com.example.universitytestproject.dto.mapper;

import com.example.universitytestproject.dto.request.StudentRequestDto;
import com.example.universitytestproject.dto.response.StudentResponseDto;
import com.example.universitytestproject.model.Student;
import com.example.universitytestproject.servise.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class StudentMapper implements RequestDtoMapper<StudentRequestDto, Student>,
        ResponseDtoMapper<StudentResponseDto, Student> {
    private final GroupService groupService;

    @Override
    public Student toModel(StudentRequestDto dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setAge(dto.getAge());
        student.setCourse(dto.getCourse());
        student.setGroup(groupService.get(dto.getGroupId()));
        return student;
    }

    @Override
    public StudentResponseDto toDto(Student student) {
        StudentResponseDto dto = new StudentResponseDto();
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setAge(student.getAge());
        dto.setCourse(student.getCourse());
        dto.setGroup(student.getGroup().getSpeciality());
        return dto;
    }
}
