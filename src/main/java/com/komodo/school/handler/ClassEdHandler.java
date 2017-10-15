package com.komodo.school.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.komodo.school.model.ClassEd;
import com.komodo.school.model.Course;
import com.komodo.school.model.Room;
import com.komodo.school.model.Semester;
import com.komodo.school.model.Teacher;
import com.komodo.school.repository.ClassEdRepository;
import com.komodo.school.repository.CourseRepository;
import com.komodo.school.repository.RoomRepository;
import com.komodo.school.repository.SemesterRepository;
import com.komodo.school.repository.StudentRepository;
import com.komodo.school.repository.TeacherRepository;
import com.komodo.school.util.ControllerUtil;

@Component
public class ClassEdHandler{

	@Autowired
	ClassEdRepository classEdRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	SemesterRepository semesterRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	StudentRepository studentRepository;
	
	public ClassEd save(ClassEd classEd, Long idCourse, Long idTeacher, Long idSemester, Long idRoom){
		Course course = courseRepository.findOne(idCourse);
		Teacher teacher = teacherRepository.findOne(idTeacher);
		Semester semester = semesterRepository.findOne(idSemester);
		Room room = roomRepository.findOne(idRoom);
		classEd.setCourse(course);
		classEd.setTeacher(teacher);
		classEd.setSemester(semester);
		classEd.setRoom(room);
		return classEdRepository.saveAndFlush(classEd);
	}
	
	public List<ClassEd> findAll(){
		return classEdRepository.findAll();
	}
	
	public ClassEd findOne(Long idSemester){
		return classEdRepository.findOne(idSemester);
	}
	
	public ClassEd update(Long idClassEd, ClassEd classEd){
		return (ClassEd) ControllerUtil.update(classEdRepository, classEd, idClassEd);
	}
	
	public ClassEd delete(Long idSemester){
		return (ClassEd) ControllerUtil.delete(classEdRepository, idSemester);
	}
}
