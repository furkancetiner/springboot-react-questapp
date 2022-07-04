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
	
	public Optional<User> findByUserId(Long id) {
		return userRepository.findById(id);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
