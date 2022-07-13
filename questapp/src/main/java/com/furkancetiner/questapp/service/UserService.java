package com.furkancetiner.questapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancetiner.questapp.entities.User;
import com.furkancetiner.questapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User getUserByUserId(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
	
	
	public User updateUser(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			return userRepository.save(foundUser);
		}
		
		return null;//return an exception
	}
	
}
