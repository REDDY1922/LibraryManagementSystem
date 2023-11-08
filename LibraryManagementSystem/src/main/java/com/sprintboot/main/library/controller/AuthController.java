package com.sprintboot.main.library.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintboot.main.library.model.User;
import com.sprintboot.main.library.service.UserService;

@RestController
public class AuthController {
	@Autowired
	private UserService  userService;
	@GetMapping("/user/login")
	public User login(Principal principal) {
		String username=principal.getName();
		User user=(User)userService.loadUserByUsername(username);
		return user;
		
	}

}
