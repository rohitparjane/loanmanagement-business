package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ServiceException;
import com.example.model.Client;
import com.example.model.User;
import com.example.repo.SqlMapper;

@Service
public class ClientServiceImpl implements ClientService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	SqlMapper sqlMapper;
	
	@Override
	public List<Client> getClients(String user){
		  
		List<Client> clients = new ArrayList();
		try {
			
		clients = sqlMapper.getClients(user);
		
		
		}
		catch(Exception e) {
			log.error(e.getMessage());
		}
		return clients;
	}
	
	@Override
	public String insertClient(Client client) throws Exception {
			
		String status = null;
		try{
			sqlMapper.insertClient(client);
			status="Client Added Successfully";
			
		}catch(Exception e) {
			log.error("Registration Failed",e.getMessage());
		}
		return status;
	}
	
	@Override
	public void deleteClient(String clName,String user) throws Exception{
		 try {
			 sqlMapper.deleteClient(clName, user);
		 }catch(Exception e) {
			 log.error("Client Deletion Failed", e.getMessage());
		 }
	}

}
