package com.example.universitytestproject.servise;

import com.example.universitytestproject.model.Professor;
import com.example.universitytestproject.repository.ProfessorRepository;
import com.example.universitytestproject.servise.impl.ProfessorServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProfessorServiceTest {
    @InjectMocks
    private ProfessorServiceImpl professorService;

    @Mock
    private ProfessorRepository professorRepository;

    private Professor expectedVoiceh;
    private Professor expectedNovak;

    @BeforeEach
    void init() {
        expectedVoiceh = new Professor("Voiceh", 37, 9);
        expectedNovak = new Professor("Novak", 53, 22);
    }

    @Test
    void create() {
        Mockito.when(professorRepository.save(expectedVoiceh)).thenReturn(expectedVoiceh);
        Professor actual = professorService.create(expectedVoiceh);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedVoiceh, actual);
    }

    @Test
    void get() {
        Long id = 7L;
        expectedNovak.setId(id);
        Mockito.when(professorRepository.getById(id)).thenReturn(expectedNovak);
        Professor actual = professorService.get(id);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedNovak, actual);
    }

    @Test
    void getAll() {
        expectedVoiceh.setId(4L);
        expectedNovak.setId(11L);
        Mockito.when(professorRepository.findAll()).thenReturn(List.of(expectedVoiceh, expectedNovak));
        List<Professor> actual = professorService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(expectedVoiceh, expectedNovak), actual);
    }
}
