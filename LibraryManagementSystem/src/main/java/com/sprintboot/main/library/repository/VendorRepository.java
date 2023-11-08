package com.sprintboot.main.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintboot.main.library.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
