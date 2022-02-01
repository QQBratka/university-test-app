package com.example.universitytestproject.servise;

import com.example.universitytestproject.model.Schedule;
import java.util.List;

public interface ScheduleService {
    Schedule create(Schedule schedule);

    Schedule get(Long id);

    List<Schedule> getAll();

    Schedule update(Schedule schedule);

    void delete(Long id);
}
