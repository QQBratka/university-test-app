package com.example.universitytestproject.servise;

import com.example.universitytestproject.model.Professor;
import java.util.List;

public interface ProfessorService {
    Professor create(Professor professor);

    Professor get(Long id);

    List<Professor> getAll();

    Professor update(Professor professor);

    void delete(Long id);
}
