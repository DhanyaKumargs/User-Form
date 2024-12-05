package com.example.UserDemo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.UserDemo.domain.User;

public interface UserService {

	List<User> getUsers();

	User getUser(String id);

	String addOrUpdateUser(User user);
	
	String verify(User user);

}
