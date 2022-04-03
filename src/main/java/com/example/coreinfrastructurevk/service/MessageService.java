package com.example.coreinfrastructurevk.service;

import com.example.coreinfrastructurevk.model.Message;
import com.example.coreinfrastructurevk.model.User;

import java.util.List;

public interface MessageService {
    Message getById(Long id);

    void save(Message user);

    void delete(long id);

    List<Message> getAll();

    List<Message> getChat(User sender, User target);

}
