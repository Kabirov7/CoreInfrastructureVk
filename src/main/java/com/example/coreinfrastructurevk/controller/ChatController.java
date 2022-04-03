package com.example.coreinfrastructurevk.controller;

import com.example.coreinfrastructurevk.dto.MessageCreateDto;
import com.example.coreinfrastructurevk.mapper.MessageMapper;
import com.example.coreinfrastructurevk.model.Message;
import com.example.coreinfrastructurevk.service.MessageService;
import com.example.coreinfrastructurevk.service.UserService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
public class ChatController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void processMessage(@RequestBody @Valid MessageCreateDto message) {
        var sender = userService.findByEmail(message.getSender());
        var target = userService.findByEmail(message.getTarget());

        Message newMessage = new Message();
        newMessage.setSender(sender.get());
        newMessage.setTarget(target.get());
        newMessage.setText(message.getText());
        messageService.save(newMessage);

//        return new ResponseEntity<>(messageDto, HttpStatus.OK);
        messagingTemplate.convertAndSendToUser(
                sender.get().getId().toString(), "/queue/messages",
                MessageMapper.INSTANCE.toDto(newMessage)
        );
    }
}
