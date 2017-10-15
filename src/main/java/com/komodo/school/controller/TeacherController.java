package com.komodo.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komodo.school.handler.TeacherHandler;
import com.komodo.school.model.Teacher;

@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {

	@Autowired
	TeacherHandler teacherHandler;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Teacher> list(){
		return teacherHandler.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Teacher create(@RequestBody Teacher teacher){
		return teacherHandler.save(teacher);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Teacher get(@PathVariable Long id){
		return teacherHandler.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Teacher update(@PathVariable Long id, @RequestBody Teacher teacher){
		return teacherHandler.update(id, teacher);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Teacher delete(@PathVariable Long id){
		return teacherHandler.delete(id);
	}

}
