package com.schedulerOnApi.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.schedulerOnApi.service.ApiService;


@RestController
public class ApiController {
	
	@Autowired ApiService apiService;
	
	@GetMapping("/")
	public ResponseEntity<Object> getChatRoomData() {
		Object chatRoomsData = apiService.getChatRooms();
		if(Objects.nonNull(chatRoomsData)) {
			return new ResponseEntity<>(chatRoomsData, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}

}
