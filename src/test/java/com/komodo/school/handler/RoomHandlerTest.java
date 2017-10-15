package com.komodo.school.handler;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.komodo.school.configuration.TestPersistenceConfiguration;
import com.komodo.school.handler.BuildingHandler;
import com.komodo.school.handler.RoomHandler;
import com.komodo.school.model.Building;
import com.komodo.school.model.Room;
import com.komodo.school.util.RandomModelCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestPersistenceConfiguration.class})
public class RoomHandlerTest {

	@Autowired
	private RoomHandler roomHandler;
	
	@Autowired
	private BuildingHandler buildingHandler;
	
	@Test
	public void testSave(){
		Building building = buildingHandler.save(RandomModelCreator.createBuilding());
		Room room = RandomModelCreator.createRoom();
		Room result = roomHandler.save(room, building.getId());
		assertNotNull(result);
		assertNotNull(result.getId());
		assertEquals(room.getCode(), result.getCode());
	}
	
	@Test
	public void testFindAll(){
		Building building = buildingHandler.save(RandomModelCreator.createBuilding());
		Room room = RandomModelCreator.createRoom();
		roomHandler.save(room, building.getId());
		List<Room> listRoom = roomHandler.findAll();
		assertNotNull(listRoom);
		assertTrue(!listRoom.isEmpty());
	}
	
	@Test
	public void testFindOne(){
		Building building = buildingHandler.save(RandomModelCreator.createBuilding());
		Room room = RandomModelCreator.createRoom();
		roomHandler.save(room, building.getId());
		Room result = roomHandler.findOne(room.getId());
		assertNotNull(result);
		assertNotNull(result.getId());
		assertEquals(room.getCode(), result.getCode());
	}
	
	@Test
	public void testDelete(){
		Building building = buildingHandler.save(RandomModelCreator.createBuilding());
		Room room = RandomModelCreator.createRoom();
		Room savedRoom = roomHandler.save(room, building.getId());
		roomHandler.delete(savedRoom.getId());
		Room result = roomHandler.findOne(savedRoom.getId());
		assertNull(result);
	}

}
