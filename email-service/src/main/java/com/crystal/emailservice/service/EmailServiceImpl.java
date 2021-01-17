package com.crystal.emailservice.service;

import com.crystal.emailservice.entity.Email;
import com.crystal.emailservice.entity.dto.UserDTO;
import com.crystal.emailservice.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailServiceImpl implements EmailService{
    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public void sendSimpleMessage(UserDTO input) {

        try{
            Email newMail = new Email();
            newMail.setTo(input.getUserName());
            newMail.setSubject("Registration Success");
            newMail.setText("You have Successfully registered");

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(newMail.getTo());
            message.setSubject(newMail.getSubject());
            message.setText(newMail.getText());

            emailRepository.save(newMail);
            emailSender.send(message);
        }catch (MailException exception){
            exception.printStackTrace();
        }
    }
}
