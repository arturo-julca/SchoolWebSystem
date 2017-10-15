package com.komodo.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komodo.school.handler.RoomHandler;
import com.komodo.school.model.Room;

@RestController
@RequestMapping("api/v1/room")
public class RoomController {

	@Autowired
	RoomHandler roomHandler;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Room> list(){
		return roomHandler.findAll();
	}
	
	@RequestMapping(value = "/building/{idbuilding}",method = RequestMethod.POST)
	public Room createAssociatedWithBuilding(@RequestBody Room room, @PathVariable Long idbuilding){
		return roomHandler.save(room, idbuilding);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Room get(@PathVariable Long id){
		return roomHandler.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Room update(@PathVariable Long id, @RequestBody Room room){
		return roomHandler.update(id, room);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Room delete(@PathVariable Long id){
		return roomHandler.delete(id);
	}

}