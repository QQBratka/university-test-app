package com.example.universitytestproject.dto.mapper;

public interface RequestDtoMapper<D, T> {
    T toModel(D dto);
}
