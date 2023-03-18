package com.donateblood.com.donateblood.service;

import com.donateblood.com.donateblood.model.UserRegistration;
import com.donateblood.com.donateblood.repo.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserRegistrationService {

    @Autowired
    UserRegistrationRepo userRegistrationRepo;

    public Boolean registerUser(UserRegistration userRegistration){
        UserRegistration userRegistrationResponse = userRegistrationRepo.save(userRegistration);
        return Objects.nonNull(userRegistrationResponse);
    }

    public Boolean checkUserId(String userId) {
        Optional<UserRegistration> userRegistration=userRegistrationRepo.findById(userId);
        return  userRegistration.isPresent();
    }
}
