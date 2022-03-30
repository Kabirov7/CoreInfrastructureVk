package com.example.coreinfrastructurevk.mapper;

import com.example.coreinfrastructurevk.dto.UserDto;
import com.example.coreinfrastructurevk.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toDto(User user);
}
