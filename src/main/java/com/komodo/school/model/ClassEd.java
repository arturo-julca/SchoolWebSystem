package com.komodo.school.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ClassEd {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_course")
	private Course course;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_teacher")
	private Teacher teacher;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_room")
	private Room room;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_semester")
	private Semester semester;
	
	@OneToMany(mappedBy = "classEd")
	private List<Schedule> listSchedules;

	@ManyToMany
	@JsonIgnore
	@JoinTable(name="CLASS_STUDENT",
		joinColumns=@JoinColumn(name="CLASS_ID", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="STUDENT_ID", referencedColumnName="ID"))
	private List<Student> listStudents;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public List<Schedule> getListSchedules() {
		return listSchedules;
	}

	public void setListSchedules(List<Schedule> listSchedules) {
		this.listSchedules = listSchedules;
	}

	public List<Student> getListStudents() {
		return listStudents;
	}

	public void setListStudents(List<Student> listStudents) {
		this.listStudents = listStudents;
	}

}
