package com.example.universitytestproject.servise.impl;

import com.example.universitytestproject.model.Group;
import com.example.universitytestproject.repository.GroupRepository;
import com.example.universitytestproject.servise.GroupService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group get(Long id) {
        return groupRepository.getById(id);
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group update(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void delete(Long id) {
        groupRepository.delete(get(id));
    }
}
