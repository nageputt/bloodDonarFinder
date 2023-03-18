package com.donateblood.com.donateblood.repo;

import com.donateblood.com.donateblood.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface UserRegistrationRepo extends JpaRepository<UserRegistration,String> {

}
