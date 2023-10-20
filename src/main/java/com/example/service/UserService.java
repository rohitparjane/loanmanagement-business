package com.example.service;

import com.example.exception.ServiceException;
import com.example.model.User;

public interface UserService {

	public User userDetails(String userName);

	public String getName();

	public String insertUser(User user) throws ServiceException;



}
