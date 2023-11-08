package com.sprintboot.main.library.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sprintboot.main.library.model.User;
import com.sprintboot.main.library.repository.UserRepository;
@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	public User insert(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loan username ..... called....");
		User user  = userRepository.findByUsername(username);
		System.out.println(user);
		return user;
	}
//User -->  UserDetails
	
}