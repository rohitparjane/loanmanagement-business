package com.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.model.EmailObj;

@Service
public class EmailUtil {


	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(EmailObj emailObj) {
		
       SimpleMailMessage message = new SimpleMailMessage();
       
       message.setFrom("parjanerohitdream11@gmail.com");
       message.setTo(emailObj.getEmail());
       message.setText(emailObj.getBody());
       message.setSubject(emailObj.getSubject());
       
       mailSender.send(message);
       
       System.out.println("mail trigered");
       
	}
}