package com.warson.warsonbe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warson.warsonbe.models.User;
import com.warson.warsonbe.services.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
	@Autowired private UserService service;
	
	@GetMapping("/users")
	public String getUsers() {
		String username = service.getUsers();
		return username;
	}
	
	@PostMapping("/users/add")
	public void createUser(@RequestBody User u) {
		service.createUser(u);
	}
}
