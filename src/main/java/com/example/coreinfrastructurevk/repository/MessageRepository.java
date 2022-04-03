package com.example.coreinfrastructurevk.repository;

import com.example.coreinfrastructurevk.model.Message;
import com.example.coreinfrastructurevk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllBySenderAndTargetOrderByCreatedAtAsc(User user, User target);
}
