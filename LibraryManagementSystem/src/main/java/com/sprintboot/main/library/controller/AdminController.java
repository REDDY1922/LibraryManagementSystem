package com.sprintboot.main.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintboot.main.library.model.Admin;
import com.sprintboot.main.library.model.User;
import com.sprintboot.main.library.service.AdminService;
import com.sprintboot.main.library.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@PostMapping("/add")
	public Admin insertadmin(@RequestBody Admin admin) {
		
		User user =admin.getUser();
		String passwordPlain =user.getPassword();
		String encodedPassword =passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
	     user.setRole("ADMIN");
	     
	     user =userService.insert(user);
	     admin.setUser(user);
	return	adminService.insert(admin);

}
}
