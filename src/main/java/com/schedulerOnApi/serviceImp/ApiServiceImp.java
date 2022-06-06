package com.schedulerOnApi.serviceImp;

import java.util.Arrays;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schedulerOnApi.service.ApiService;

@Service
public class ApiServiceImp implements ApiService{
	
	@Autowired RestTemplate restTemplate;
	@Autowired ObjectMapper mapper;
	
//	Logger log = LoggerFactory.getLogger(ApiServiceImp.class);
	
	@Override
//	@Scheduled(cron = "0 * * ? * *")   // Scheduled After 1 minutes
//	@Scheduled(fixedDelay = 1000)
	public Object getChatRooms() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		//headers.setBearerAuth(getToken());
	    HttpEntity <String> requestEntity = new HttpEntity<String>(headers);
	      
	    String url = "https://stage.communication-scaffold.oodleslab.com/chat-api/chat/user/chatrooms?userId=1000";
	    
	    //String str = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYW5rYWoucmFqQG9vZGxlcy5pbyIsInJvbGVzIjpbIlJPTEVfVVNFUiIsIlJPTEVfQURNSU4iLCJST0xFX1NVUEVSQURNSU4iLCJST0xFX1NVUEVSX0FETUlOIl0sInVzZXJJZCI6MTAwMCwidXNlcm5hbWUiOiJQYW5rYWogUmFqIiwianRpIjoiZmJkNTkzNDdjNjE3NGE1NDgiLCJleHAiOjE2NTQ1MzI3NDd9.ogiZxCNKIGgFT9CY3bitcxQYLpYtsuFez293kVWPYOM";
	    
	    headers.setBearerAuth("Bearer "+getToken());
	    
	    ResponseEntity<Object> exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Object.class);
	 //   System.out.println(exchange);
	    
	 //   log.info("Value: {}", exchange.getBody());
	    
	  // System.out.println(exchange.getBody());

	    return exchange.getBody();
		
	}
	
//	@Scheduled(cron = "0 * * ? * *")
	//@Scheduled(fixedDelay = 1000)
	public String getToken() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

		String tokenurl = "https://stage.communication-scaffold.oodleslab.com/chat-api/chat/auth/authorize?username=pankaj.raj@oodles.io&password=Dpp@12";
		ResponseEntity<Object> exchangeData = restTemplate.exchange(tokenurl, HttpMethod.GET, requestEntity,Object.class);
		
		HashMap convertValue = mapper.convertValue(exchangeData.getBody(), HashMap.class);
		
	//	log.info("Value: {}", convertValue.get("access_token").toString());
		
	//	System.out.println("token : " + convertValue.get("access_token").toString());
		
		//System.out.println(convertValue);
		//System.out.println(convertValue.get("access_token"));
		// System.out.println("exchanged data is"+exchange.getBody().toString());
		return convertValue.get("access_token").toString();
		 

	}
	
}
