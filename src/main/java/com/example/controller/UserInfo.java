package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ServiceException;
import com.example.model.User;
import com.example.service.UserService;
//import com.example.service.UserServiceImpl;
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserInfo {
	
    @Autowired
	UserService userService;
    
    @GetMapping(value="/Hi")
	public String home(){
		
		return "hello";
		
	}
    
    @GetMapping(value="/userName")
	public String name(){
		String userName;
		userName=userService.getName();
		return userName;
    }
	
	@GetMapping(value="/user/{userName}")
	public User userDetails(@PathVariable String userName){
		System.out.println("HI");
		User userDetails = new User();
		userDetails = userService.userDetails(userName);
		System.out.println(userDetails);
		return userDetails;
		
	}
	
	@PostMapping(value="/user")
	public ResponseEntity<String> insertUser( @RequestBody User user ) throws ServiceException{
		System.out.println("Insert User");
		
		String status= userService.insertUser(user);
		if(status!=null) {
		return new ResponseEntity<>(status,HttpStatus.OK);
		}else {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	//	return "Success";
	}
	
	@PostMapping(value="/login")
	public boolean login( @RequestBody User user) throws ServiceException {
		System.out.println("Login"+user);
		boolean login = false;
		login = userService.login(user);
		return login;
	}

}
