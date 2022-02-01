package com.example.universitytestproject.servise.impl;

import com.example.universitytestproject.model.Subject;
import com.example.universitytestproject.repository.SubjectRepository;
import com.example.universitytestproject.servise.SubjectService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Override
    public Subject create(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject get(Long id) {
        return subjectRepository.getById(id);
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(Long id) {
        subjectRepository.delete(get(id));
    }
}
