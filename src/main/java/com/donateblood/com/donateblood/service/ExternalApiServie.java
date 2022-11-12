package com.donateblood.com.donateblood.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
	
	public List<String> getCountries() {
		List<String> countries = null;
		Object countriesObject =restTemplate.getForObject(countryUrl, Object.class);
		List<Object> c=Arrays.asList(countriesObject);
		Map<String,Object> data= (Map<String, Object>) c.get(0);
		Map<String,Map<String,String>> dataa= (Map<String, Map<String, String>>) data.get("Results");
		dataa.entrySet().forEach(a->{
			countries.add(a.getValue().get("country"));
		});
		return  countries;
	}

}
