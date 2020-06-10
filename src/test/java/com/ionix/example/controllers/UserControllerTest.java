package com.ionix.example.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ionix.example.persistence.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	UserController userController;
	
	@Test
	public void testAddNewUser() {
		User user = new User();
		user.setName("Test");
		user.setUsername("testUsername");
		user.setEmail("test@test.com");
		user.setPhone("123456789");
		ResponseEntity<String> string = userController.addNewUser(user);
		string.getStatusCode().is2xxSuccessful();
	}

	@Test
	public void testGetAllUsers() {
		ResponseEntity<Iterable<User>> userList = userController.getAllUsers();
		userList.getStatusCode().is2xxSuccessful();
	}

	@Test
	public void testGetUserByEmail() {
		ResponseEntity<Iterable<User>> userList = userController.getUserByEmail("test@test.com");
		userList.getStatusCode().is2xxSuccessful();
	}

}
