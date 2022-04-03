package com.example.coreinfrastructurevk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageDto implements Serializable {
    String id;
    String text;
    UserDto sender;
    UserDto target;
    String createdAt;

}
