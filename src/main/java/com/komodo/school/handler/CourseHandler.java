package com.komodo.school.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.komodo.school.model.Course;
import com.komodo.school.repository.CourseRepository;
import com.komodo.school.util.ControllerUtil;

@Component
public class CourseHandler{

	@Autowired
	CourseRepository courseRepository;
	
	public Course save(Course course){
		return courseRepository.saveAndFlush(course);
	}
	
	public List<Course> findAll(){
		return courseRepository.findAll();
	}
	
	public Course findOne(Long idCourse){
		return courseRepository.findOne(idCourse);
	}
	
	public Course update(Long idCourse, Course course){
		return (Course) ControllerUtil.update(courseRepository, course, idCourse);
	}
	
	public Course delete(Long idCourse){
		return (Course) ControllerUtil.delete(courseRepository, idCourse);
	}
}
