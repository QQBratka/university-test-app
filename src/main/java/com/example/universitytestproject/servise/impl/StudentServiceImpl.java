package com.example.universitytestproject.servise.impl;

import com.example.universitytestproject.model.Student;
import com.example.universitytestproject.repository.StudentRepository;
import com.example.universitytestproject.servise.StudentService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student get(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(get(id));
    }

    @Override
    public List<String> findByIdAndScheduleDay(Long id, String day) {
        return studentRepository.findByStudentIdAndDay(id, day.toUpperCase());
    }
}
