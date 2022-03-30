package com.example.coreinfrastructurevk.service;

import com.example.coreinfrastructurevk.model.Message;
import com.example.coreinfrastructurevk.repository.MessageRepository;
import com.example.coreinfrastructurevk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImplementation implements MessageService{
    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message getById(Long id) {
        return messageRepository.getById(id);
    }

    @Override
    public void save(Message message) {messageRepository.save(message);}

    @Override
    public void delete(long id) {messageRepository.deleteById(id);}

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }
}
