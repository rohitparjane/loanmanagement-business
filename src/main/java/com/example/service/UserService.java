package com.example.service;

import com.example.exception.ServiceException;
import com.example.model.EmailObj;
import com.example.model.User;

public interface UserService {

	public User userDetails(String userName);

	public String getName();

	public String insertUser(User user) throws ServiceException;
	
	public void sendMail(EmailObj mailObj) throws Exception;

    public void sendOtp(String email) throws Exception;
    
    public boolean validateOtp(String email, int otp) throws Exception;

}
