package com.example.universitytestproject.servise;

import com.example.universitytestproject.model.Professor;
import com.example.universitytestproject.model.Subject;
import com.example.universitytestproject.repository.SubjectRepository;
import com.example.universitytestproject.servise.impl.SubjectServiceImpl;
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
class SubjectServiceTest {
    @InjectMocks
    private SubjectServiceImpl subjectService;

    @Mock
    private SubjectRepository subjectRepository;

    private Subject expectedArt;
    private Subject expectedMusic;

    @BeforeEach
    void init() {
        Professor voiceh = new Professor("Voiceh", 37, 9);
        expectedArt = new Subject("Art", 105, voiceh);
        Professor novak = new Professor("Novak", 53, 22);
        expectedMusic = new Subject("Music", 303, novak);
    }

    @Test
    void create() {
        Mockito.when(subjectRepository.save(expectedArt)).thenReturn(expectedArt);
        Subject actual = subjectService.create(expectedArt);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedArt, actual);
    }

    @Test
    void get() {
        Long id = 7L;
        expectedMusic.setId(id);
        Mockito.when(subjectRepository.getById(id)).thenReturn(expectedMusic);
        Subject actual = subjectService.get(id);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedMusic, actual);
    }

    @Test
    void getAll() {
        expectedArt.setId(4L);
        expectedMusic.setId(11L);
        Mockito.when(subjectRepository.findAll()).thenReturn(List.of(expectedArt, expectedMusic));
        List<Subject> actual = subjectService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(expectedArt, expectedMusic), actual);
    }
}
