package com.example.universitytestproject.servise;

import com.example.universitytestproject.model.Group;
import java.util.List;

public interface GroupService {
    Group create(Group group);

    Group get(Long id);

    List<Group> getAll();

    Group update(Group group);

    void delete(Long id);
}
