package com.sprintboot.main.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintboot.main.library.model.User;
import com.sprintboot.main.library.model.Vendor;
import com.sprintboot.main.library.service.UserService;
import com.sprintboot.main.library.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private VendorService vendorService;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@PostMapping("/add")
	public Vendor insertVendor(@RequestBody Vendor vendor) {
		
		User user =vendor.getUser();
		String passwordPlain =user.getPassword();
		String encodedPassword =passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
	     user.setRole("VENDOR");
	     
	     user =userService.insert(user);
	     vendor.setUser(user);
	return	vendorService.insert(vendor);

}
}
