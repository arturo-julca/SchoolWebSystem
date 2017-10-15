package com.komodo.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String dayOfTheWeek;
	private int hourStart;
	private int hourEnd;
	private int typeClass;
	
	public int getTypeClass() {
		return typeClass;
	}

	public void setTypeClass(int typeClass) {
		this.typeClass = typeClass;
	}

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_class")
	private ClassEd classEd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	public int getHourStart() {
		return hourStart;
	}

	public void setHourStart(int hourStart) {
		this.hourStart = hourStart;
	}

	public int getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(int hourEnd) {
		this.hourEnd = hourEnd;
	}

	public ClassEd getClassEd() {
		return classEd;
	}

	public void setClassEd(ClassEd classEd) {
		this.classEd = classEd;
	}

}
