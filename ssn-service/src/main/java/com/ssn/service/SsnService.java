package com.ssn.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SsnService {
	
	private static final  Map<String,String> map=new HashMap<>();
	
	static
	{
		map.put("01","WASHINGTON");
		map.put("02", "OHIO");
		map.put("03", "TEXAS");
		map.put("04", "CALIFORNIA");
		map.put("05", "FLORIDA");
		
	
	}
	
	public String getStateName(String ssn)
	{
		String pattern = "^[0-9]{9}$";
		if (!ssn.matches(pattern)) {
			return null;
		}

		String code = ssn.substring(ssn.length() - 2);
		return map.get(code);
	}

}
