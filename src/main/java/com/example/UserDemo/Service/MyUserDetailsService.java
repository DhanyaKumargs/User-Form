package com.example.UserDemo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.UserDemo.Repository.UserRepository;
import com.example.UserDemo.domain.User;
import com.example.UserDemo.domain.UserPrincipal;



@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUserName(username);
	
		if(user == null) {
			System.err.println("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrincipal(user);
	}

}
