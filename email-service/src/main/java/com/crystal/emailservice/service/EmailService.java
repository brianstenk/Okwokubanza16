package com.crystal.emailservice.service;

import com.crystal.emailservice.entity.dto.UserDTO;

public interface EmailService {
    void sendSimpleMessage(UserDTO payload);
}
