package com.example.universitytestproject.servise.impl;

import com.example.universitytestproject.model.Professor;
import com.example.universitytestproject.repository.ProfessorRepository;
import com.example.universitytestproject.servise.ProfessorService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    @Override
    public Professor create(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor get(Long id) {
        return professorRepository.getById(id);
    }

    @Override
    public List<Professor> getAll() {
        return professorRepository.findAll();
    }

    @Override
    public Professor update(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void delete(Long id) {
        professorRepository.delete(get(id));
    }
}
