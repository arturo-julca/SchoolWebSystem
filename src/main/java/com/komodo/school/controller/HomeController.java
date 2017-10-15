package com.komodo.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komodo.school.model.Student;

@RestController
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Student> getStudents(){
		Student st = new Student();
		st.setCode("1213");
		st.setFirstName("test");
		st.setLastName("heck");
		st.setId(1L);
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}
}
