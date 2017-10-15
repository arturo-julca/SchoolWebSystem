package com.komodo.school.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Building{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String code;
	
	@OneToMany(mappedBy = "building")
	private List<Room> listRooms;
	 
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

	public List<Room> getListRooms() {
		return listRooms;
	}

	public void setListRooms(List<Room> listRooms) {
		this.listRooms = listRooms;
	}

	@Override
	public String toString() {
		return "Building [id=" + id + ", name=" + name + ", code=" + code + "]";
	}

}
