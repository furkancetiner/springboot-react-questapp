package com.furkancetiner.questapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furkancetiner.questapp.entities.User;
import com.furkancetiner.questapp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	//@Autowired
	private UserService userService;
	
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public User createUser(@RequestBody User user){
		return userService.save(user);
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable Long userId){
		return userService.getUserByUserId(userId);
	}
	
	@GetMapping()
	public List<User> getAllUsers(){
		return  userService.findAll();
	}
	
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable Long userId,@RequestBody User newUser){
		return updateUser(userId, newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		
		User user = userService.getUserByUserId(userId);
		
		if(user!=null) {
			userService.deleteUser(userId);
		}	
	}
	
	
}
