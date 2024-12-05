package com.example.UserDemo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.UserDemo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	User findByid(String id);
	User findByUserName(String name);

}
