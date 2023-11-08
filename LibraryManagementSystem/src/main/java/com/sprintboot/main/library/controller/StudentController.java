package com.sprintboot.main.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintboot.main.library.model.Student;
import com.sprintboot.main.library.model.User;
import com.sprintboot.main.library.service.StudentService;
import com.sprintboot.main.library.service.UserService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@PostMapping("/add")
	public Student insertStudent(@RequestBody Student student) {
		
		User user =student.getUser();
		String passwordPlain =user.getPassword();
		String encodedPassword =passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
	     user.setRole("STUDENT");
	     
	     user =userService.insert(user);
	     student.setUser(user);
	return	studentService.insert(student);
		
	}
	

}
