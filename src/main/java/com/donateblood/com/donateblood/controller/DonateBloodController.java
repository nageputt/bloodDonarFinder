package com.donateblood.com.donateblood.controller;

import java.util.Collections;
import java.util.List;

import com.donateblood.com.donateblood.model.UserRegistration;
import com.donateblood.com.donateblood.service.BloodGroupsService;
import com.donateblood.com.donateblood.service.UserRegistrationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.donateblood.com.donateblood.service.ExternalApiServie;

@RestController
@RequestMapping("/api")
public class DonateBloodController {
	
	@Autowired
	ExternalApiServie apiServie;

	@Autowired
	BloodGroupsService bloodGroupsService;

	@Autowired
	UserRegistrationService userRegistrationService;

	
	@GetMapping("/getCountries")
	public ResponseEntity<List<String>> getCountries() {
		ResponseEntity<List<String>> responseEntity;
		List<String> countries = apiServie.getCountries();
		if(!CollectionUtils.isEmpty(countries)){
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(countries);
		}else{
			responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(Collections.emptyList());
		}
		return responseEntity;
	}

	@GetMapping("/getBloodGroups")
	public ResponseEntity<List<String>> getBloodGroups(){
		ResponseEntity<List<String>> responseEntity;
		List<String> bloodGroupList = bloodGroupsService.getBloodGroups();
		if(!CollectionUtils.isEmpty(bloodGroupList)){
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(bloodGroupList);
		}else{
			responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(Collections.emptyList());
		}
		return responseEntity;

	}

	@GetMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody UserRegistration userRegistration){
		ResponseEntity<String> responseEntity = null;
		if(userRegistrationService.registerUser(userRegistration)){
			responseEntity = ResponseEntity.status(HttpStatus.CREATED).body("User Created successfully.");
		}else{
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Create User.");
		}
		return  responseEntity;
	}

	@GetMapping("/checkUserId/{userId}")
	public ResponseEntity<String> registerUser(@PathVariable String userId){
		ResponseEntity<String> responseEntity;
		if(userRegistrationService.checkUserId(userId)){
			responseEntity = ResponseEntity.status(HttpStatus.OK).body("UserId Exists");
		}else{
			responseEntity = ResponseEntity.status(HttpStatus.OK).body("UserId Not Exist");
		}
		return  responseEntity;
	}
}
