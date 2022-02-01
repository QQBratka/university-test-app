package com.example.universitytestproject.servise;

import com.example.universitytestproject.model.Subject;
import java.util.List;

public interface SubjectService {
    Subject create(Subject subject);

    Subject get(Long id);

    List<Subject> getAll();

    Subject update(Subject subject);

    void delete(Long id);
}
