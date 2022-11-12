package com.donateblood.com.donateblood.service;

import com.donateblood.com.donateblood.model.UserRegistration;
import com.donateblood.com.donateblood.repo.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRegistrationService {

    @Autowired
    UserRegistrationRepo userRegistrationRepo;

    public String registerUser(UserRegistration userRegistration){
        userRegistrationRepo.save(userRegistration);
        return "User Created successfully";
    }

    public String checkUserId(String userId) {
        Optional<UserRegistration> userRegistration=userRegistrationRepo.findById(userId);
        if(userRegistration.isPresent()){
            return "UserId Exists";
        }else{
            return "UserId Not Exist";
        }
    }
}
