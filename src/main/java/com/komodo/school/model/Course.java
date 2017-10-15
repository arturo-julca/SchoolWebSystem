package com.komodo.school.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String code;
	private int type;
	private int credits;
	private int cicle;
	
	@OneToMany(mappedBy = "course")
	List<ClassEd> listClassEds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getCicle() {
		return cicle;
	}

	public void setCicle(int cicle) {
		this.cicle = cicle;
	}

	public List<ClassEd> getListClassEds() {
		return listClassEds;
	}

	public void setListClassEds(List<ClassEd> listClassEds) {
		this.listClassEds = listClassEds;
	}
	
}
