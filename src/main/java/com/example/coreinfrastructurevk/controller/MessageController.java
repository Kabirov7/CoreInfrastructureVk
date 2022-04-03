package com.example.coreinfrastructurevk.controller;

import com.example.coreinfrastructurevk.dto.MessageCreateDto;
import com.example.coreinfrastructurevk.dto.MessageDto;
import com.example.coreinfrastructurevk.mapper.MessageMapper;
import com.example.coreinfrastructurevk.model.Message;
import com.example.coreinfrastructurevk.model.User;
import com.example.coreinfrastructurevk.service.MessageService;
import com.example.coreinfrastructurevk.service.UserService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<MessageDto> allMessages(Authentication authentication) {
        List<Message> messages = this.messageService.getAll();
        return new ResponseEntity(messages.stream().map(m -> MessageMapper.INSTANCE.toDto(m)), HttpStatus.OK);
    }

    @GetMapping("chat/{id}")
    public ResponseEntity<MessageDto> getChat(@PathVariable("id") Long id, Principal principal){
        var sender = userService.findByEmail(principal.getName());
        var reciever = userService.getById(id);
        List<Message> messages = this.messageService.getChat(sender.get(), reciever);
        return new  ResponseEntity(messages.stream().map(m -> MessageMapper.INSTANCE.toDto(m)), HttpStatus.OK);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<MessageDto> getMessage(@PathVariable("id") Long id) {
        Message message = messageService.getById(id);
        return new ResponseEntity<>(MessageMapper.INSTANCE.toDto(message), HttpStatus.OK);
    }

}
