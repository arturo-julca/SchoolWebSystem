package com.komodo.school.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.komodo.school.configuration.TestPersistenceConfiguration;
import com.komodo.school.model.Building;
import com.komodo.school.util.RandomModelCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestPersistenceConfiguration.class})
public class BuildingHandlerTest {

	@Autowired
	private BuildingHandler buildingHandler;
	
	@Test
	public void testHandlerOperations(){
		Building building = RandomModelCreator.createBuilding();
		Building result = buildingHandler.save(building);
		assertNotNull(result);
		assertEquals(building.getName(), result.getName());
	}
	
	@Test
	public void testFindAll(){
		buildingHandler.save(RandomModelCreator.createBuilding());
		List<Building> listBuilding = buildingHandler.findAll();
		assertNotNull(listBuilding);
		assertTrue(!listBuilding.isEmpty());
	}
	
	@Test
	public void testFindOne(){
		Building created = buildingHandler.save(RandomModelCreator.createBuilding());
		Building result = buildingHandler.findOne(created.getId());
		assertNotNull(result);
		assertEquals(created.getCode(), result.getCode());
	}
	
	@Test
	public void testUpdate(){
		Building created = buildingHandler.save(RandomModelCreator.createBuilding());
		created.setName("Mechanical Engineering Faculty");
		created.setCode("MEF");
		Building result = buildingHandler.update(created.getId(), created);
		assertNotNull(result);
		assertEquals(created.getName(), result.getName());
		assertEquals(created.getName(), result.getName());
	}
	
	@Test
	public void testDelete(){
		Building created = buildingHandler.save(RandomModelCreator.createBuilding());
		buildingHandler.delete(created.getId());
		Building building = buildingHandler.findOne(created.getId());
		assertNull(building);
	}
}
