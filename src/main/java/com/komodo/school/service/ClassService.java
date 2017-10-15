package com.komodo.school.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.komodo.school.model.ClassEd;
import com.komodo.school.model.Student;
import com.komodo.school.repository.ClassEdRepository;
import com.komodo.school.repository.StudentRepository;

@Service
public class ClassService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ClassEdRepository classEdRepository;

	public ClassEd registerStudent(Long idStudent, Long idClass){
		Student student = studentRepository.findOne(idStudent);
		ClassEd classEd = classEdRepository.findOne(idClass);
		if(classEd.getListStudents()==null){
			classEd.setListStudents(new ArrayList<Student>());
		}
		classEd.getListStudents().add(student);
		return classEdRepository.saveAndFlush(classEd);	
	}
}
