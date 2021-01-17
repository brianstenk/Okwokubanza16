package com.crystal.emailservice.repository;

import com.crystal.emailservice.entity.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email, Long> {

}
