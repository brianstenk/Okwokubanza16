package com.crystal.userservice.service;

import com.crystal.userservice.entity.User;
import com.crystal.userservice.kafka.producer.Sender;
import com.crystal.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Value("${spring.kafka.topic.userRegistered}")
    private String USER_REGISTERED_TOPIC;

    private Sender sender;

    @Override
    public User registerUser(User input) {

        User createdUser = userRepository.save(input);
        sender.send(USER_REGISTERED_TOPIC, createdUser);
        return createdUser;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }
}
