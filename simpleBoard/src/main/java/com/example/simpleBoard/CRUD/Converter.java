package com.example.simpleBoard.CRUD;

public interface Converter<DTO, ENTITY>{

    DTO toDto(ENTITY entity);

    ENTITY toEntity(DTO dto);
}
