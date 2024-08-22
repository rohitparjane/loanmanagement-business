package com.example.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ServiceException;
import com.example.model.Client;
import com.example.model.History;
import com.example.model.Payment;
import com.example.model.User;
import com.example.repo.SqlMapper;
import com.example.utils.JwtUtil;

@Service
public class ClientServiceImpl implements ClientService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	SqlMapper sqlMapper;
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	SqlSessionFactory sessionFactory;
	
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
			 sqlMapper.deleteAllEntries(clName+"_"+user);
		 }catch(Exception e) {
			 log.error("Client Deletion Failed", e.getMessage());
		 }
	}

	@Override
	public Payment getHistory(String clName,HttpServletRequest request) throws Exception {
		 List<History> history =new ArrayList();
		 Payment payment =new Payment();
		try {
			 String bearer=request.getHeader("Authorization").substring(7);
			 String userName=jwtUtil.extractUsername(bearer);
			 history = sqlMapper.getHistory(clName+"_"+userName);
			
			 Double tAmount = sqlMapper.getAmount(userName, clName);
			 
			 payment.setEntries(history);
			 payment.setTotalAmount(tAmount);
			
			 System.out.println(history);
		 }catch(Exception e) {
			 log.error("Failed to load Payment History", e.getMessage());
			
		}
		return payment;
	}

	@Override
	public void insertEntry(String clName,Double amount,HttpServletRequest request) throws Exception {
		 
	//	try {
			String bearer=request.getHeader("Authorization").substring(7);
			  String userName=jwtUtil.extractUsername(bearer);
			 sqlMapper.insertEntry(clName+"_"+userName,amount);
			 sqlMapper.updateAmount(clName, amount,userName);
			 
	//	}
		//catch(Exception e) {
	//		log.error("Failed to insert Entry", e.getMessage());
			//throw new exception
	//	}
		
	}

	@Override
	public void deleteEntry(int srNo,String clName,Double amount, String clUser) {
			SqlSession sqlSession= sessionFactory.openSession();
			SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
			amount = -amount;
		try {
			mapper.deleteEntry(srNo);
			mapper.updateAmount(clName, amount, clUser);
			sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
			log.error("Failed to delete Entry", e.getMessage());
		}
		finally {
			sqlSession.clearCache();
			sqlSession.close();
		}
	}
	
	@Override
	public void saveReminderDate(String clUser,String clName,LocalDate date) {
		 
		
			sqlMapper.updateReminderDate(clUser,clName,date);
		
	}
	
	

}
