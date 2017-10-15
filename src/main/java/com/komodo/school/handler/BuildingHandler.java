package com.komodo.school.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.komodo.school.model.Building;
import com.komodo.school.repository.BuildingRepository;
import com.komodo.school.util.ControllerUtil;

@Component
public class BuildingHandler{

	@Autowired
	BuildingRepository buildingRepository;
	
	public Building save(Building building){
		return buildingRepository.saveAndFlush(building);
	}
	
	public List<Building> findAll(){
		return buildingRepository.findAll();
	}
	
	public Building findOne(Long idRoom){
		return buildingRepository.findOne(idRoom);
	}
	
	public Building update(Long idBuilding, Building building){
		return (Building) ControllerUtil.update(buildingRepository, building, idBuilding);
	}
	
	public Building delete(Long idBuilding){
		return (Building) ControllerUtil.delete(buildingRepository, idBuilding);
	}
}
