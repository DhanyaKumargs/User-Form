package com.example.UserDemo.endPoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserDemo.Service.UserService;
import com.example.UserDemo.domain.User;



@RestController
public class UserEndPoint {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/user")
	public User getUser(@RequestParam(value="id") String id){
		return userService.getUser(id);
		
	}
	
	@PostMapping("/add-user")
	public ResponseEntity<String> createUser(@RequestBody User user){
		
	
		return new ResponseEntity<String>(userService.addOrUpdateUser(user) ,HttpStatus.CREATED);
		
	}
	

	@PostMapping("/login")
	public String login(@RequestBody User user) {

	        return userService.verify(user);
	    }
	

}
