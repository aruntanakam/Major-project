package com.ars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ars.entity.RegistrationEntity;
import com.ars.service.IRegistrationService;

@RestController
@RequestMapping("/ars/api")
public class RegistrationController {
	
	@Autowired
	private IRegistrationService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerApplication(@RequestBody RegistrationEntity entity)
	{
		return new ResponseEntity<>(service.registerCustomer(entity),HttpStatus.OK);
	}

}
