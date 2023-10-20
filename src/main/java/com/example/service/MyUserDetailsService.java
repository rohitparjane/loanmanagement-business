package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.repo.SqlMapper;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private SqlMapper sqlMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 String password = sqlMapper.getPassword(username);
		 
		 if(password==null) {
			 throw new UsernameNotFoundException("User Not  Found");
		 } 
		 User user =new User(username, password, new ArrayList<>());
//		 UserDetails userDetails = User.builder()
//		            .username(username)
//		            .password(password)
//		            .roles(null)
//		            .build();
		return user;
	}

}
