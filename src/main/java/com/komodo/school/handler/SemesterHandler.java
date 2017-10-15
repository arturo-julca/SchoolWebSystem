package com.komodo.school.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.komodo.school.model.Semester;
import com.komodo.school.repository.SemesterRepository;
import com.komodo.school.util.ControllerUtil;

@Component
public class SemesterHandler{

	@Autowired
	SemesterRepository semesterRepository;
	
	public Semester save(Semester semester){
		return semesterRepository.saveAndFlush(semester);
	}
	
	public List<Semester> findAll(){
		return semesterRepository.findAll();
	}
	
	public Semester findOne(Long idSemester){
		return semesterRepository.findOne(idSemester);
	}
	
	public Semester update(Long idSemester, Semester semester){
		return (Semester) ControllerUtil.update(semesterRepository, semester, idSemester);
	}
	
	public Semester delete(Long idSemester){
		return (Semester) ControllerUtil.delete(semesterRepository, idSemester);
	}
}
