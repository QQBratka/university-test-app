package com.example.universitytestproject.controller;

import com.example.universitytestproject.dto.mapper.GroupMapper;
import com.example.universitytestproject.dto.request.GroupRequestDto;
import com.example.universitytestproject.dto.response.GroupResponseDto;
import com.example.universitytestproject.model.Group;
import com.example.universitytestproject.servise.GroupService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final GroupMapper groupMapper;

    @PostMapping
    public GroupResponseDto create(@RequestBody @Valid GroupRequestDto dto) {
        return groupMapper.toDto(groupService.create(groupMapper.toModel(dto)));
    }

    @GetMapping("/get/{id}")
    public GroupResponseDto get(@PathVariable Long id) {
        return groupMapper.toDto(groupService.get(id));
    }

    @GetMapping("/get")
    public List<GroupResponseDto> getAll() {
        return groupService.getAll().stream()
                .map(groupMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public GroupResponseDto update(@PathVariable Long id,
                                   @RequestBody @Valid GroupRequestDto dto) {
        Group group = groupMapper.toModel(dto);
        group.setId(id);
        return groupMapper.toDto(groupService.create(group));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        groupService.delete(id);
    }
}
