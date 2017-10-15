package com.komodo.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komodo.school.handler.SemesterHandler;
import com.komodo.school.model.Semester;

@RestController
@RequestMapping("api/v1/semester")
public class SemesterController {

	@Autowired
	SemesterHandler semesterHandler;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Semester> list(){
		return semesterHandler.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Semester create(@RequestBody Semester student){
		return semesterHandler.save(student);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Semester get(@PathVariable Long id){
		return semesterHandler.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Semester update(@PathVariable Long id, @RequestBody Semester semester){
		return semesterHandler.update(id, semester);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Semester delete(@PathVariable Long id){
		return semesterHandler.delete(id);
	}

}
