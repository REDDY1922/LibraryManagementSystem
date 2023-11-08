package com.sprintboot.main.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintboot.main.library.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
