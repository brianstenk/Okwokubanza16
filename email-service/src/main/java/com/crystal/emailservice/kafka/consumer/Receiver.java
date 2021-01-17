package com.crystal.emailservice.kafka.consumer;

import com.crystal.emailservice.entity.dto.UserDTO;
import com.crystal.emailservice.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "${spring.kafka.topic.userRegistered}")
    public void receive(UserDTO payload){
        LOGGER.info("received payload='{}'", payload);
        emailService.sendSimpleMessage(payload);
        latch.countDown();
    }
}
