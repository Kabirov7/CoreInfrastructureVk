package com.example.coreinfrastructurevk.mapper;

import com.example.coreinfrastructurevk.dto.MessageDto;
import com.example.coreinfrastructurevk.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserMapper.class})
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    @Mapping(source = "order.from", target = "userDto")
    @Mapping(source = "order.target", target = "userDto")
    MessageDto toDto(Message message);
}
