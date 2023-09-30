package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.Client;

public interface ClientService {

	     public List<Client> getClients(String user);

		public String insertClient(Client client) throws Exception;

		void deleteClient(String clName, String user) throws Exception;
}
