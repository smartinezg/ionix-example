package com.ionix.example.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ionix.example.persistence.User;
import com.ionix.example.repository.UserRepository;

@Controller
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path="/addUser")
	public @ResponseBody ResponseEntity<String> addNewUser (@Valid @RequestBody User user) {
		if (user == null)
			return new ResponseEntity<>("Problem saving", HttpStatus.BAD_REQUEST);
		if (user.getEmail() == null || user.getName() == null || user.getUsername() == null || user.getPhone() == null)
			return new ResponseEntity<>("Problem saving", HttpStatus.BAD_REQUEST);
		try {
			userRepository.save(user);
		} catch (Exception ex) {
			return new ResponseEntity<>("Problem saving", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Saved", HttpStatus.OK);
	}

	@GetMapping(path="/allUsers")
	public @ResponseBody ResponseEntity<Iterable<User>> getAllUsers() {
		Iterable<User> users = userRepository.findAll();
		if (users == null) {
			return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
		} else if (users != null && !users.iterator().hasNext()) {
			return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping(path="/getUserByEmail")
	public @ResponseBody ResponseEntity<Iterable<User>> getUserByEmail(@RequestParam String email) {
		Iterable<User> users =  userRepository.findByEmail(email);
		if (users == null) {
			return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
		} else if (users != null && !users.iterator().hasNext()) {
			return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
}