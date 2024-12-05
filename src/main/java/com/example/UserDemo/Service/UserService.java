package com.example.UserDemo.Service;

import java.util.List;

import com.example.UserDemo.UserDto;
import com.example.UserDemo.domain.User;

public interface UserService {

	List<UserDto> getUsers();

	User getUser(String id);

	String addOrUpdateUser(User user);
	
	String verify(User user);

}
