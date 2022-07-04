package com.furkancetiner.questapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.furkancetiner.questapp.entities.User;
import com.furkancetiner.questapp.service.UserService;

@SpringBootTest
class QuestappApplicationTests {

	@Autowired
	UserService userService;
	
	@Test
	void contextLoads() {
	}

	
	@Test
	void saveUser() {
		User user = new User().builder().userName("furkan").id(10L).password("1235").build();
		
		assertThat(userService.save(user)).isNotNull();
		System.out.println(user);
	}
}
