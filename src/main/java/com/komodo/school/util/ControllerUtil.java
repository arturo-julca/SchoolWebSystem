package com.komodo.school.util;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import com.komodo.school.model.Semester;

public class ControllerUtil {

	static public Object update(JpaRepository semesterRepository, Object model, Long id){
		Object existingObject = semesterRepository.findOne(id);
		BeanUtils.copyProperties(model, existingObject);
		return semesterRepository.saveAndFlush(existingObject);
	}
	
	static public Object delete(JpaRepository semesterRepository, Long id){
		Object existingObject = semesterRepository.findOne(id);
		semesterRepository.delete(existingObject);
		return existingObject;
	}
}
