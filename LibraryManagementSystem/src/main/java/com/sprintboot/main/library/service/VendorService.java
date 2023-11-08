package com.sprintboot.main.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintboot.main.library.model.Vendor;
import com.sprintboot.main.library.repository.VendorRepository;
@Service
public class VendorService {
	@Autowired
	private VendorRepository vendorRepository;

	public Vendor insert(Vendor vendor) {
		
		return vendorRepository.save(vendor);
	}

}
