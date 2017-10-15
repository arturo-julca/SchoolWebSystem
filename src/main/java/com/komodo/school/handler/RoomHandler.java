package com.komodo.school.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.komodo.school.model.Building;
import com.komodo.school.model.Room;
import com.komodo.school.repository.BuildingRepository;
import com.komodo.school.repository.RoomRepository;
import com.komodo.school.util.ControllerUtil;

@Component
public class RoomHandler{

	@Autowired
	RoomRepository roomRepository;
	@Autowired
	BuildingRepository buildingRepository;
	
	public Room save(Room room, Long idBuilding){
		Building building = buildingRepository.getOne(idBuilding);
		room.setBuilding(building);
		return roomRepository.saveAndFlush(room);
	}
	
	public List<Room> findAll(){
		return roomRepository.findAll();
	}
	
	public Room findOne(Long idRoom){
		return roomRepository.findOne(idRoom);
	}
	
	public Room update(Long idRoom, Room room){
		return (Room) ControllerUtil.update(roomRepository, room, idRoom);
	}
	
	public Room delete(Long idRoom){
		return (Room) ControllerUtil.delete(roomRepository, idRoom);
	}
}
