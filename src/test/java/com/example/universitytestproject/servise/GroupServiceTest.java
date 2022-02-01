package com.example.universitytestproject.servise;

import com.example.universitytestproject.model.Day;
import com.example.universitytestproject.model.Group;
import com.example.universitytestproject.model.Professor;
import com.example.universitytestproject.model.Schedule;
import com.example.universitytestproject.model.Speciality;
import com.example.universitytestproject.model.Subject;
import com.example.universitytestproject.repository.GroupRepository;
import com.example.universitytestproject.servise.impl.GroupServiceImpl;
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
class GroupServiceTest {
    @InjectMocks
    private GroupServiceImpl groupService;

    @Mock
    private GroupRepository groupRepository;

    private Group expectedEconomic;
    private Group expectedIT;

    @BeforeEach
    void init() {
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
        expectedEconomic = new Group(
                Speciality.HISTORICAL,
                List.of(voiceh, novak, usov, permak),
                List.of(friday, monday)
        );
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
        expectedIT = new Group(
                Speciality.INTERNET_TECHNOLOGIES,
                List.of(selih, osnov, semenovich, trepaliuk),
                List.of(thursday, wednesday)
        );
    }

    @Test
    void create() {
        Mockito.when(groupRepository.save(expectedEconomic)).thenReturn(expectedEconomic);
        Group actual = groupService.create(expectedEconomic);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedEconomic, actual);
    }

    @Test
    void get() {
        Long id = 7L;
        expectedIT.setId(id);
        Mockito.when(groupRepository.getById(id)).thenReturn(expectedIT);
        Group actual = groupService.get(id);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedIT, actual);
    }

    @Test
    void getAll() {
        expectedEconomic.setId(4L);
        expectedIT.setId(11L);
        Mockito.when(groupRepository.findAll()).thenReturn(List.of(expectedEconomic, expectedIT));
        List<Group> actual = groupService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(expectedEconomic, expectedIT), actual);
    }
}
