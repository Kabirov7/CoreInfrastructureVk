package com.example.coreinfrastructurevk.controller;

import com.example.coreinfrastructurevk.dto.MessageCreateDto;
import com.example.coreinfrastructurevk.mapper.MessageMapper;
import com.example.coreinfrastructurevk.model.Message;
import com.example.coreinfrastructurevk.model.User;
import com.example.coreinfrastructurevk.service.MessageService;
import com.example.coreinfrastructurevk.service.UserService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    public void processMessage(@RequestBody @Valid MessageCreateDto message, Principal principal) {
        Message newMessage = new Message();
        newMessage.setSender(userService.findByEmail(principal.getName()).get());
        newMessage.setTarget(userService.getById(message.getTarget()));
        newMessage.setText(message.getText());
        messageService.save(newMessage);

        var messageDto = MessageMapper.INSTANCE.toDto(newMessage);
//        return new ResponseEntity<>(messageDto, HttpStatus.OK);
        messagingTemplate.convertAndSendToUser(
                message.getTarget().toString(), "/queue/messages",
                messageDto
        );
    }
}
