package com.komodo.school.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String firstName;
	private String lastName;
	@Column(nullable = true, columnDefinition="int(4) default 2006")
	private int yearRegister;
	
	@ManyToMany(mappedBy="listStudents")
	private List<ClassEd> listClassEds;
	
	public int getYearRegister() {
		return yearRegister;
	}
	public void setYearRegister(int yearRegister) {
		this.yearRegister = yearRegister;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<ClassEd> getListClassEds() {
		return listClassEds;
	}
	public void setListClassEds(List<ClassEd> listClassEds) {
		this.listClassEds = listClassEds;
	}
	
	
}
