package com.example.coreinfrastructurevk.repository;

import com.example.coreinfrastructurevk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long id);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
}
