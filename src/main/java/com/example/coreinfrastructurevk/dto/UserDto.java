package com.example.coreinfrastructurevk.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
    Long id;
    String email;
    Long name;

    public UserDto() {
    }

    public UserDto(Long id, String email, Long name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }
}
