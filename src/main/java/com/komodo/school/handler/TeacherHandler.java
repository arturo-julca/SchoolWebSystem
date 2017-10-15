package com.komodo.school.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.komodo.school.model.Teacher;
import com.komodo.school.repository.TeacherRepository;
import com.komodo.school.util.ControllerUtil;

@Component
public class TeacherHandler{

	@Autowired
	TeacherRepository teacherRepository;
	
	public Teacher save(Teacher teacher){
		return teacherRepository.saveAndFlush(teacher);
	}
	
	public List<Teacher> findAll(){
		return teacherRepository.findAll();
	}
	
	public Teacher findOne(Long idTeacher){
		return teacherRepository.findOne(idTeacher);
	}
	
	public Teacher update(Long idTeacher, Teacher teacher){
		return (Teacher) ControllerUtil.update(teacherRepository, teacher, idTeacher);
	}
	
	public Teacher delete(Long idTeacher){
		return (Teacher) ControllerUtil.delete(teacherRepository, idTeacher);
	}
}
