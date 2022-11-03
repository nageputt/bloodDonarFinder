package com.donateblood.com.donateblood.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiServie {
	
	@Value("${url.countryUrl}")
	private String countryUrl;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Object> getCountries() {
		Object countries =restTemplate.getForObject(countryUrl, Object.class);
		List<Object> c=Arrays.asList(countries);
		for (Object object : c) {
			System.out.println(object);
		}
		return c;
	}

}
