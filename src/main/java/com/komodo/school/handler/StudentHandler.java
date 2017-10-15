package com.komodo.school.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.komodo.school.model.ClassEd;
import com.komodo.school.model.Student;
import com.komodo.school.repository.ClassEdRepository;
import com.komodo.school.repository.StudentRepository;
import com.komodo.school.util.ControllerUtil;

@Component
public class StudentHandler{

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ClassEdRepository classEdRepository;
	
	public Student save(Student student){
		return studentRepository.saveAndFlush(student);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student findOne(Long idStudent){
		return studentRepository.findOne(idStudent);
	}
	
	public Student update(Long idStudent, Student student){
		return (Student) ControllerUtil.update(studentRepository, student, idStudent);
	}
	
	public Student delete(Long idStudent){
		return (Student) ControllerUtil.delete(studentRepository, idStudent);
	}
}
