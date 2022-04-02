package com.example.coreinfrastructurevk.service;

import com.example.coreinfrastructurevk.model.User;
import com.example.coreinfrastructurevk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void save(User user) {userRepository.save(user);}

    @Override
    public void delete(long id) {userRepository.deleteById(id);}

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public List<User> getFriends(User user) {
        return userRepository.findAllByFriendsContains(user);
    }
    @Override
    public List<User> getNotFriends(User user) {
        return userRepository.findAllByFriendsNotContains(user);
    }
}
