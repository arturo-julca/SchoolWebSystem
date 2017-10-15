package com.komodo.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komodo.school.handler.ClassEdHandler;
import com.komodo.school.model.ClassEd;
import com.komodo.school.service.ClassService;

@RestController
@RequestMapping("api/v1/class")
public class ClassController {

	@Autowired
	ClassEdHandler classEdHandler;
	
	@Autowired
	ClassService classService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ClassEd> list(){
		return classEdHandler.findAll();
	}
	
	@RequestMapping(value = "/course/{idCourse}/teacher/{idTeacher}/semester/{idSemester}/room/{idRoom}", method = RequestMethod.POST)
	public ClassEd create(@RequestBody ClassEd classEd, 
			@PathVariable Long idCourse,
			@PathVariable Long idTeacher,
			@PathVariable Long idSemester,
			@PathVariable Long idRoom){
		return classEdHandler.save(classEd, idCourse, idTeacher, idSemester, idRoom);
	}
	
	@RequestMapping(value = "/{idClass}/student/{idStudent}", method = RequestMethod.POST)
	public ClassEd register(@PathVariable Long idStudent, @PathVariable Long idClass){
		return classService.registerStudent(idClass, idStudent);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ClassEd get(@PathVariable Long id){
		return classEdHandler.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ClassEd update(@PathVariable Long id, 
			@RequestBody ClassEd classEd){
		return classEdHandler.update(id, classEd);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ClassEd delete(@PathVariable Long id){
		return classEdHandler.delete(id);
	}
}
