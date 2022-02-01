package com.example.universitytestproject.servise;

import com.example.universitytestproject.model.*;
import com.example.universitytestproject.repository.ScheduleRepository;
import com.example.universitytestproject.servise.impl.ScheduleServiceImpl;
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
class ScheduleServiceTest {
    @InjectMocks
    private ScheduleServiceImpl scheduleService;

    @Mock
    private ScheduleRepository scheduleRepository;

    private Schedule expectedFriday;
    private Schedule expectedMonday;

    @BeforeEach
    void init() {
        Professor voiceh = new Professor("Voiceh", 37, 9);
        Subject art = new Subject("Art", 105, voiceh);
        Professor novak = new Professor("Novak", 53, 22);
        Subject music = new Subject("Music", 303, novak);
        expectedFriday = new Schedule(Day.FRIDAY,
                Speciality.HISTORICAL, List.of(art, music));
        Professor usov = new Professor("Usov", 45, 12);
        Subject zoology = new Subject("zoology", 201, usov);
        Professor permak = new Professor("Permak", 29, 2);
        Subject geometry = new Subject("Geometry", 303, permak);
        expectedMonday = new Schedule(Day.MONDAY,
                Speciality.ECONOMICS, List.of(zoology, geometry));
    }

    @Test
    void create() {
        Mockito.when(scheduleRepository.save(expectedFriday)).thenReturn(expectedFriday);
        Schedule actual = scheduleService.create(expectedFriday);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedFriday, actual);
    }

    @Test
    void get() {
        Long id = 7L;
        expectedMonday.setId(id);
        Mockito.when(scheduleRepository.getById(id)).thenReturn(expectedMonday);
        Schedule actual = scheduleService.get(id);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedMonday, actual);
    }

    @Test
    void getAll() {
        expectedFriday.setId(4L);
        expectedMonday.setId(11L);
        Mockito.when(scheduleRepository.findAll()).thenReturn(List.of(expectedFriday, expectedMonday));
        List<Schedule> actual = scheduleService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(expectedFriday, expectedMonday), actual);
    }
}
