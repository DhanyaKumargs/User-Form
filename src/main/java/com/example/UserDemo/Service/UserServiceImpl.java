package com.example.UserDemo.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.UserDemo.UserDto;
import com.example.UserDemo.Repository.UserRepository;
import com.example.UserDemo.domain.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTService jwtService;
	
	private BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder(12);
	
	@Override
	public List<UserDto> getUsers() {
		// TODO Auto-generated method stub
		List<User> users =  userRepository.findAll();
		List<UserDto> usersDto = new ArrayList<UserDto>();
		users.stream().forEach(user->{
			usersDto.add(modelMapper.map(user, UserDto.class));
		});
		return usersDto;
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		 User user = userRepository.findByid(id);
		 user.setPassword(bcryptEncoder.encode(user.getPassword()));
		 return user;
	}

	@Override
	public String addOrUpdateUser(User user) {
		
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		// TODO Auto-generated method stub
		 userRepository.save(user);
		
		return "user ".concat(user.getUserName()).concat(" created successfully");
	}

	public String verify(User user) {
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
	
		if(authenticate.isAuthenticated())
			return jwtService.getTocken(user.getUserName());	
		return "fail";
	}
	
}
