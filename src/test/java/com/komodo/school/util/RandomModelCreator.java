package com.komodo.school.util;

import com.komodo.school.model.Building;
import com.komodo.school.model.ClassEd;
import com.komodo.school.model.Course;
import com.komodo.school.model.Room;
import com.komodo.school.model.Schedule;
import com.komodo.school.model.Semester;
import com.komodo.school.model.Student;
import com.komodo.school.model.Teacher;

public class RandomModelCreator {

	public static Building createBuilding(){
		Building building = new Building();
		building.setName("Electrical Engineering Faculty");
		building.setCode("EEF");
		return building;	
	}
	
	public static Room createRoom(){
		Room room = new Room();
		room.setCode("FK101");
		return room;
	}
	
	public static Student createStudent(){
		Student student = new Student();
		student.setCode("FK101");
		student.setFirstName("FK101");
		student.setLastName("FK101");
		student.setYearRegister(2017);
		return student;
	}
	
	public static Course createCourse(){
		Course course = new Course();
		course.setName("Chemistry");
		course.setCode("CH101");
		course.setType(1);
		course.setCredits(5);
		course.setCicle(2017);
		return course;
	}
	
	public static Schedule createSchedule(){
		Schedule schedule = new Schedule();
		schedule.setDayOfTheWeek("monday");
		schedule.setHourStart(10);
		schedule.setTypeClass(12);
		return schedule;
	}
	
	public static ClassEd createClassEd(){
		ClassEd classEd = new ClassEd();
		classEd.setCode("CH101-2007II-1");
		return classEd;
	}
	
	public static Semester createSemester(){
		Semester semester = new Semester();
		semester.setName("2017-II");
		return semester;
	}
	
	public static Teacher createTeacher(){
		Teacher teacher = new Teacher();
		teacher.setFirstName("Juan");
		teacher.setFirstName("Perez");
		teacher.setCode("9000201");
		return teacher;
	}
}
