package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.SendNotificationServiceImpl;

@RestController
public class NotificationController {
	
	@Autowired
	private SendNotificationServiceImpl nService;
	
	@GetMapping(value="/notification")
	public void sendNotificaton() {
		System.out.println("In Controller");
		nService.sendNotification();
	}

}
