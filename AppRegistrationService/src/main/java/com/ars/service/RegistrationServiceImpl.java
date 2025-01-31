package com.ars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ars.entity.RegistrationEntity;
import com.ars.exception.InvalidSsnException;
import com.ars.repository.IRegistrationRepository;

import reactor.core.publisher.Mono;

@Service
public class RegistrationServiceImpl implements IRegistrationService {
	
	@Autowired
	private WebClient client;
	
	@Value("${ssn-web.end-point}")
	private String ssn_uri;
	
	@Value("${statename}")
	private String stateName;
	
	@Autowired
	private IRegistrationRepository repo;

	@Override
	public String registerCustomer(RegistrationEntity entity) {
		
		String state=client.get().uri(ssn_uri,entity.getSsn()).exchangeToMono(response->{
			
			HttpStatusCode statusCode=response.statusCode();
			
			if(statusCode.is2xxSuccessful())
			{
				return response.bodyToMono(String.class);
			}
			else if (statusCode.is4xxClientError()) {
                // Handle 4xx responses
                return Mono.error(new InvalidSsnException("Invalid ssn"));
            } else if (statusCode.is5xxServerError()) {
                // Handle 5xx responses
                return Mono.error(new RuntimeException("Server error while calling ssn service: " + statusCode));
            } else {
                // Handle other status codes
                return Mono.error(new RuntimeException("Unexpected status code while calling ssn service: " + statusCode));
            }
			
		}).block();
		
		if(stateName!=null && stateName.equalsIgnoreCase(state))
		{
			entity.setStateName(stateName);
			entity=repo.save(entity);
			return "Application regitered with id:"+entity.getApplicationId();
		}
		else
		{
			throw new InvalidSsnException("Invalid ssn");
		}
	}

}
