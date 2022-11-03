package com.donateblood.com.donateblood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donateblood.com.donateblood.service.ExternalApiServie;

@RestController
@RequestMapping("/api")
public class DonateBloodController {
	
	@Autowired
	ExternalApiServie apiServie;
	
	@GetMapping("/getCountries")
	public List<Object> getCountries() {
		return apiServie.getCountries();
	}

}
