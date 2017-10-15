package com.komodo.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komodo.school.handler.StudentHandler;
import com.komodo.school.model.Student;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

	@Autowired
	StudentHandler studentHandler;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Student> list(){
		return studentHandler.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Student create(@RequestBody Student student){
		return studentHandler.save(student);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student get(@PathVariable Long id){
		return studentHandler.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Student update(@PathVariable Long id, @RequestBody Student student){
		return studentHandler.update(id, student);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Student delete(@PathVariable Long id){
		return studentHandler.delete(id);
	}

}
