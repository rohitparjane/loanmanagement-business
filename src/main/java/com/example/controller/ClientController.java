package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.Client;
import com.example.service.ClientService;

@RestController
public class ClientController {
	
	 @Autowired
		ClientService clientService;
	 
	 @GetMapping(value="/clients/{user}")
	 public List<Client> getClients(@PathVariable String user){
		 List<Client> clients = new ArrayList();
		 if (user == null)
			 System.out.println("User null");
		   
		 clients = clientService.getClients(user);
		 
		 return clients;
	 }
	 
	 @PostMapping(value="/client")
	 public ResponseEntity<String> insertClient(@RequestBody Client client) throws Exception{
		 
		 if (client.getClName()!=null && !client.getClName().isEmpty()) {
			String status=  clientService.insertClient(client);
			System.out.println("cldetails"+client);
			if(status!=null) {
				return new ResponseEntity<>(status,HttpStatus.OK);
				}else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
		 }else {
			 return new ResponseEntity<>("Client name is null",HttpStatus.BAD_REQUEST);
		 }
	 }
	 
	@DeleteMapping(value="/deleteClient")
	public void deleteClient(@RequestParam String clName, @RequestParam String user) throws Exception{
		 System.out.print("Client"+ clName + user);  
		if(!clName.isEmpty()&& !user.isEmpty()&& clName!=null && user!=null) {
			System.out.println("in if block");
			  clientService.deleteClient(clName, user);
		  }
		  else {
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Clien Not Found");
		  }
		  
	  
	}
}
