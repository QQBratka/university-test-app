package com.example.universitytestproject.repository;

import com.example.universitytestproject.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
