package com.ssn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.service.SsnService;

@RestController
@RequestMapping("/ssn/api")
public class OperationsController {

	private SsnService service;

	@Autowired
	public OperationsController(SsnService service) {
		this.service = service;
	}

	@GetMapping("/find/{ssn}")
	public ResponseEntity<String> getState(@PathVariable("ssn") String ssn) {

	
		String statename = service.getStateName(ssn);

		return (statename == null) ? (new ResponseEntity<>("Invalid ssn", HttpStatus.BAD_REQUEST))
				: (new ResponseEntity<>(statename, HttpStatus.OK));
	}

}
