package com.example.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ServiceException;
import com.example.model.EmailObj;
import com.example.model.User;
import com.example.repo.SqlMapper;
import com.example.utils.EmailUtil;

import java.util.Random;

//import com.example.repo.SqlMapper;
import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	SqlMapper sqlMapper;
	
	@Autowired
	EmailUtil emailUtil;
	
	public String getName() {
		String name=sqlMapper.getName();
		return name;
	}
	@Override
	public User userDetails(String userName) {
		User userDetails = new User();
		userDetails = sqlMapper.getUser(userName);
		System.out.println(userDetails);
		return userDetails;
	}
	@Override
	public String insertUser(User user) throws ServiceException {
		String status="";
	//	try{
			int Count= sqlMapper.checkUser(user.userName);
		System.out.println(Count);
		if(Count!=0) {
			status="User Id Already Present";
		}else {
			sqlMapper.insertUser(user);
			status="User Added Successfully";
		 }
		//}catch(Exception e) {
		//	log.error("Registration Failed",e.getMessage());
	//	}
		return status;
	}
	@Override
	public void sendMail(EmailObj emailObj) throws Exception {

		emailUtil.sendMail(emailObj);
		
	}
	@Override
	public void sendOtp(String email) throws Exception {
		 
		  int otp = generateRandomOtp();
		  String sotp=String.valueOf(otp); 
		  sqlMapper.generateOtp(email, otp);
		  EmailObj emailObj = new EmailObj();
		  emailObj.setEmail(email);
		  emailObj.setSubject("Loan Management Otp ");
		  emailObj.setBody(sotp);
		  
		  emailUtil.sendMail(emailObj);
	}
	
	
	
	 @Override
	public boolean validateOtp(String email,int otp) throws Exception {
		 
		 Integer dotp=sqlMapper.validateOtp(email);
		 
		 if(dotp!=null &&dotp==otp) {
			 
			sqlMapper.updateOtpStatus(email, otp);
			      return true;
		 }
		 else { 
			      return false;
		 }
		 
		
	}
	private int generateRandomOtp() {
	        // Generate a random 6-digit OTP
	        Random random = new Random();
	        return 100000 + random.nextInt(900000);
	    }

	
	
//	private creatrObj()
	
	
	
}
