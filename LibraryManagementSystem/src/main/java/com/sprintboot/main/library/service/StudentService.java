package com.sprintboot.main.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintboot.main.library.model.Student;
import com.sprintboot.main.library.repository.StudentRepository;
@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Student insert(Student student) {
		
		return studentRepository.save(student);
	}

}
