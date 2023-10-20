package com.example.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ServiceException;
import com.example.model.User;
import com.example.repo.SqlMapper;
//import com.example.repo.SqlMapper;
import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	SqlMapper sqlMapper;
	
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
		try{
			int Count= sqlMapper.checkUser(user.userName);
		System.out.println(Count);
		if(Count!=0) {
			status="User Id Already Present";
		}else {
			sqlMapper.insertUser(user);
			status="User Added Successfully";
		 }
		}catch(Exception e) {
			log.error("Registration Failed",e.getMessage());
		}
		return status;
	}
	
}
