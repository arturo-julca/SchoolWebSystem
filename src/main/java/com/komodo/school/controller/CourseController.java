package com.komodo.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komodo.school.handler.CourseHandler;
import com.komodo.school.model.Course;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

	@Autowired
	CourseHandler courseHandler;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Course> list(){
		return courseHandler.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Course create(@RequestBody Course course){
		return courseHandler.save(course);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Course get(@PathVariable Long id){
		return courseHandler.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Course update(@PathVariable Long id, @RequestBody Course course){
		return courseHandler.update(id, course);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Course delete(@PathVariable Long id){
		return courseHandler.delete(id);
	}

}