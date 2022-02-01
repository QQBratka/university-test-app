package com.example.universitytestproject.servise;

import com.example.universitytestproject.model.Day;
import com.example.universitytestproject.model.Group;
import com.example.universitytestproject.model.Professor;
import com.example.universitytestproject.model.Schedule;
import com.example.universitytestproject.model.Speciality;
import com.example.universitytestproject.model.Student;
import com.example.universitytestproject.model.Subject;
import com.example.universitytestproject.repository.StudentRepository;
import com.example.universitytestproject.servise.impl.StudentServiceImpl;
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
class StudentServiceTest {
    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    private Student expectedOrlando;
    private Student expectedDiego;

    @BeforeEach
    void init() {
        // Orlando Sanchez
        Professor voiceh = new Professor("Voiceh", 37, 9);
        Subject art = new Subject("Art", 105, voiceh);
        Professor novak = new Professor("Novak", 53, 22);
        Subject music = new Subject("Music", 303, novak);
        Schedule friday = new Schedule(Day.FRIDAY,
                Speciality.HISTORICAL,
                List.of(art, music));
        Professor usov = new Professor("Usov", 45, 12);
        Subject zoology = new Subject("zoology", 201, usov);
        Professor permak = new Professor("Permak", 29, 2);
        Subject geometry = new Subject("Geometry", 303, permak);
        Schedule monday = new Schedule(Day.MONDAY,
                Speciality.HISTORICAL,
                List.of(zoology, geometry));
        Group economic = new Group(
                Speciality.HISTORICAL,
                List.of(voiceh, novak, usov, permak),
                List.of(friday, monday)
        );
        expectedOrlando = new Student("Orlando", "Sanchez", 22, 1, economic);
        // Diego Alvarez
        Professor selih = new Professor("Slih", 42, 11);
        Subject spring = new Subject("Spring", 302, selih);
        Professor osnov = new Professor("Osnov", 67, 39);
        Subject hibernate = new Subject("Hibernate", 306, osnov);
        Schedule thursday = new Schedule(Day.THURSDAY,
                Speciality.INTERNET_TECHNOLOGIES,
                List.of(spring, hibernate));
        Professor semenovich = new Professor("Semenovich", 32, 4);
        Subject databases = new Subject("Databases", 203, semenovich);
        Professor trepaliuk = new Professor("Permak", 26, 0);
        Subject algorithms = new Subject("Algorithms", 107, trepaliuk);
        Schedule wednesday = new Schedule(Day.MONDAY,
                Speciality.INTERNET_TECHNOLOGIES,
                List.of(databases, algorithms));
        Group it = new Group(
                Speciality.INTERNET_TECHNOLOGIES,
                List.of(selih, osnov, semenovich, trepaliuk),
                List.of(thursday, wednesday)
        );
        expectedDiego = new Student("Diego", "Alvarez", 23, 4, it);
    }

    @Test
    void create() {
        Mockito.when(studentRepository.save(expectedOrlando)).thenReturn(expectedOrlando);
        Student actual = studentService.create(expectedOrlando);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedOrlando, actual);
    }

    @Test
    void get() {
        Long id = 7L;
        expectedDiego.setId(id);
        Mockito.when(studentRepository.getById(id)).thenReturn(expectedDiego);
        Student actual = studentService.get(id);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedDiego, actual);
    }

    @Test
    void getAll() {
        expectedOrlando.setId(4L);
        expectedDiego.setId(11L);
        Mockito.when(studentRepository.findAll()).thenReturn(List.of(expectedOrlando, expectedDiego));
        List<Student> actual = studentService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(expectedOrlando, expectedDiego), actual);
    }

    @Test
    void findByIdAndScheduleDay() {
        String day = "FRIDAY";
        Long id = 9L;
        Professor voiceh = new Professor("Voiceh", 37, 9);
        Subject art = new Subject("Art", 105, voiceh);
        Professor novak = new Professor("Novak", 53, 22);
        Subject music = new Subject("Music", 303, novak);
        Mockito.when(studentRepository.findByStudentIdAndDay(id, day))
                .thenReturn(List.of(art.getName(), music.getName()));
        List<String> actual = studentService.findByIdAndScheduleDay(id, day);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(art.getName(), music.getName()), actual);
    }
}
