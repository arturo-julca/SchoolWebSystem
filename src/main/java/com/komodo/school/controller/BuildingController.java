package com.komodo.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komodo.school.handler.BuildingHandler;
import com.komodo.school.model.Building;

@RestController
@RequestMapping("api/v1/building")
public class BuildingController {

	@Autowired
	BuildingHandler buildingHandler;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Building> list(){
		return buildingHandler.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Building create(@RequestBody Building building){
		return buildingHandler.save(building);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Building get(@PathVariable Long id){
		return buildingHandler.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Building update(@PathVariable Long id, @RequestBody Building building){
		return buildingHandler.update(id, building);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Building delete(@PathVariable Long id){
		return buildingHandler.delete(id);
	}

}
