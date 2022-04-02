package com.example.coreinfrastructurevk.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


public class MessageCreateDto implements Serializable {

    String target;
    String text;

    public MessageCreateDto(String target, String text) {
        this.target = target;
        this.text = text;
    }

    public MessageCreateDto() {
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
