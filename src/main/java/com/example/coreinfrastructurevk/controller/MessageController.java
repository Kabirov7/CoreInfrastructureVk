package com.example.coreinfrastructurevk.controller;

import com.example.coreinfrastructurevk.dto.MessageCreateDto;
import com.example.coreinfrastructurevk.dto.MessageDto;
import com.example.coreinfrastructurevk.mapper.MessageMapper;
import com.example.coreinfrastructurevk.model.Message;
import com.example.coreinfrastructurevk.model.User;
import com.example.coreinfrastructurevk.service.MessageService;
import com.example.coreinfrastructurevk.service.UserService;
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

//    @MessageMapping
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public void createMessage(@RequestBody @Valid MessageCreateDto message,
//                                                    Principal principal) {
//        Optional<User> sender = userService.findByEmail(principal.getName());
//        Optional<User> target = userService.findByEmail(message.getTarget());
//        Message newMessage = new Message();
//        newMessage.setSender(sender.get());
//        newMessage.setTarget(target.get());
//        newMessage.setText(message.getText());
//        messageService.save(newMessage);
//
//        MessageDto messageDto = MessageMapper.INSTANCE.toDto(newMessage);
//
////        return new ResponseEntity<>(messageDto, HttpStatus.OK);
//        messagingTemplate.convertAndSendToUser(
//                sender.get().getId().toString(), "/queue/messages",
//                newMessage
//        );
//    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<MessageDto> getMessage(@PathVariable("id") Long id) {
        Message message = messageService.getById(id);
        return new ResponseEntity<>(MessageMapper.INSTANCE.toDto(message), HttpStatus.OK);
    }

}
