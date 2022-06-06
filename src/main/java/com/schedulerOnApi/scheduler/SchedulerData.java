package com.schedulerOnApi.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.schedulerOnApi.service.ApiService;


@Service
public class SchedulerData {
	
	@Autowired ApiService apiService;
	
	Logger log = LoggerFactory.getLogger(ApiService.class);
	
	Logger logger = LoggerFactory.getLogger(SchedulerData.class);
	
//	@Scheduled(fixedDelay = 1000)
	@Scheduled(cron = "0 * * ? * *")
	public void run() {
		log.info("Value: {}",apiService.getChatRooms());
	//	System.out.println(apiService.getChatRooms());
		
	}

}
