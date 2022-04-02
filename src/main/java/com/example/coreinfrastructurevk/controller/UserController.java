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
import java.util.ArrayList;
import java.util.List;

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

}
