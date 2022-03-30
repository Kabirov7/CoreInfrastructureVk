package com.example.coreinfrastructurevk.controller;

import com.example.coreinfrastructurevk.dto.MessageDto;
import com.example.coreinfrastructurevk.mapper.MessageMapper;
import com.example.coreinfrastructurevk.model.Message;
import com.example.coreinfrastructurevk.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/api/v1/messages/")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<MessageDto> allMessages() {
        List<Message> messages = this.messageService.getAll();
        return new ResponseEntity(messages.stream().map(m -> MessageMapper.INSTANCE.toDto(m)), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Message> createMessage(@RequestBody @Valid Message message) {
        this.messageService.save(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<MessageDto> getMessage(@PathVariable("id") Long id) {
        Message message = messageService.getById(id);
        return new ResponseEntity<>(MessageMapper.INSTANCE.toDto(message), HttpStatus.OK);
    }

}
