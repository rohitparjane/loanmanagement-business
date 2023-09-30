package com.example.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
//	String userName;
	public ServiceException(String userName) {
		super(String.format("User not found with id %s ", userName));}
		
		public ServiceException(String userName,String present) {
			super(String.format("User id %s is already registered", userName));
//		this.userName = userName;
		
	}

}
