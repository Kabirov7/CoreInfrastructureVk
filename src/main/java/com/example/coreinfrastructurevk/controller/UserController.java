package com.example.coreinfrastructurevk.controller;

import com.example.coreinfrastructurevk.dto.UserDto;
import com.example.coreinfrastructurevk.mapper.UserMapper;
import com.example.coreinfrastructurevk.model.User;
import com.example.coreinfrastructurevk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<UserDto> allUsers() {
        List<User> users = this.userService.getAll();
        return new ResponseEntity(users.stream().map(u -> UserMapper.INSTANCE.toDto(u)), HttpStatus.OK);
    }

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getAllFriends(Principal principal) {
        Optional<User> user = this.userService.findByEmail(principal.getName());
        List<User> users = this.userService.getFriends(user.get());
        return new ResponseEntity(users.stream().map(u -> UserMapper.INSTANCE.toDto(u)), HttpStatus.OK);
    }

    @RequestMapping(value = "/not_friends", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getAllNotFriends(Principal principal) {
        Optional<User> user = this.userService.findByEmail(principal.getName());
        List<User> users = this.userService.getNotFriends(user.get());
        return new ResponseEntity(users.stream().map(u -> UserMapper.INSTANCE.toDto(u)), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        this.userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        User u = this.userService.getById(id);
        return new ResponseEntity<>(UserMapper.INSTANCE.toDto(u), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}/add_friend", method = RequestMethod.GET)
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, Principal principal) {
        Optional<User> currentUser = userService.findByEmail(principal.getName());
        User u = this.userService.getById(id);
        u.addFriend(currentUser.get());
        userService.save(u);
        return new ResponseEntity<>(UserMapper.INSTANCE.toDto(u), HttpStatus.OK);
    }

}
