package com.example.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.example.model.Client;
import com.example.model.History;
import com.example.model.Payment;

public interface ClientService {

	     public List<Client> getClients(String user);

		public String insertClient(Client client) throws Exception;

		void deleteClient(String clName, String user) throws Exception;
		
		public Payment getHistory(String clUser, HttpServletRequest request) throws Exception;
		
		void insertEntry(String clName, Double amount,HttpServletRequest request) throws Exception;

		public void deleteEntry(int srNo,String clName,Double amount,String clUser)throws Exception;

		void saveReminderDate(String clUser, String clName, LocalDateTime date);
		
		
}
