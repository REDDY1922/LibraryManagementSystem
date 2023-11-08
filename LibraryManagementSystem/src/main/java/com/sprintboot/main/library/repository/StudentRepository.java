package com.sprintboot.main.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintboot.main.library.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
