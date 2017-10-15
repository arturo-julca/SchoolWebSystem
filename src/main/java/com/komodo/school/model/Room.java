package com.komodo.school.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_building")
	private Building building;
	
	@OneToMany(mappedBy = "room")
	private List<ClassEd> listClassEds;
	
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
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	public List<ClassEd> getListClassEds() {
		return listClassEds;
	}
	public void setListClassEds(List<ClassEd> listClassEds) {
		this.listClassEds = listClassEds;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", code=" + code + "]";
	}
	
}
