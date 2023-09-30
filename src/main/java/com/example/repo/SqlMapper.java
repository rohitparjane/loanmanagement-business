package com.example.repo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Client;
import com.example.model.User;

@Repository
@Mapper
public interface SqlMapper {
	
	User getUser(@Param("userName")String userName);
	void insertUser( User user);
    String getName();
    int checkUser(@Param("userName") String userName);
    String getPassword(@Param("userName") String userName);
    List<Client> getClients(@Param("user") String user);
    void insertClient(Client client);
    void deleteClient(@Param("clName") String clName, @Param("user") String user);
}
