package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Client;
import com.example.model.EmailObj;
import com.example.repo.SqlMapper;
import com.example.utils.EmailUtil;

@Service
public class SendNotificationServiceImpl {
	
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
    @Autowired
	EmailUtil emailUtil;
    
	@Autowired
	SqlMapper sqlMapper;
	
	
	public void sendNotification() {
		System.out.println("In Service");
			List<Client> clients = new ArrayList();
			LocalDate today = LocalDate.now();
			EmailObj emailObj = new EmailObj();
			try {
				System.out.println(today);
			clients = sqlMapper.gerReminderDetails(today);
			System.out.println(clients);
			
			clients = clients.stream().filter(client-> client.getClReminderDate().equals(today))
					.collect(Collectors.toList());
			
			for(Client client :clients) {
				System.out.println(client);
			  emailObj.setEmail(client.getClEmail());
			  emailObj.setSubject("Payment reminder");
			  String body = String.format("Hi %s,\n\n"+"Your payment of %s is still pending. make your payment"
			  						+"your Due Date is %s. \n\n"+"Thank You \n%s",client.getClName(),
			  						client.getClAmount(),client.getClReminderDate(),client.getUser());
			  emailObj.setBody(body);
			  
			  emailUtil.sendMail(emailObj);
				}
			
			}
			catch(Exception e) {
				log.error(e.getMessage());
			}
			
		}
		

}
