package com.example.universitytestproject.servise;

import com.example.universitytestproject.model.Student;
import java.util.List;

public interface StudentService {
    Student create(Student student);

    Student get(Long id);

    List<Student> getAll();

    Student update(Student student);

    void delete(Long id);

    List<String> findByIdAndScheduleDay(Long id, String day);
}
