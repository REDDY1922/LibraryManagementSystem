package com.sprintboot.main.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintboot.main.library.model.Admin;
import com.sprintboot.main.library.repository.AdminRepository;
@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	public Admin insert(Admin admin) {
		
		return adminRepository.save(admin);
	}

}
