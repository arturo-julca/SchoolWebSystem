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
import com.komodo.school.model.Student;
import com.komodo.school.util.RandomModelCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestPersistenceConfiguration.class})
public class StudentHandlerTest {

	@Autowired
	private StudentHandler studentHandler;
	
	@Test
	public void testHandlerOperations(){
		Student building = RandomModelCreator.createStudent();
		Student result = studentHandler.save(building);
		assertNotNull(result);
		assertEquals(building.getCode(), result.getCode());
	}
	
	@Test
	public void testFindAll(){
		studentHandler.save(RandomModelCreator.createStudent());
		List<Student> listBuilding = studentHandler.findAll();
		assertNotNull(listBuilding);
		assertTrue(!listBuilding.isEmpty());
	}
	
	@Test
	public void testFindOne(){
		Student created = studentHandler.save(RandomModelCreator.createStudent());
		Student result = studentHandler.findOne(created.getId());
		assertNotNull(result);
		assertEquals(created.getCode(), result.getCode());
	}
	
	@Test
	public void testUpdate(){
		Student created = studentHandler.save(RandomModelCreator.createStudent());
		created.setFirstName("updated first name");
		created.setLastName("updated last name");
		Student result = studentHandler.update(created.getId(), created);
		assertNotNull(result);
		assertEquals(created.getFirstName(), result.getFirstName());
		assertEquals(created.getLastName(), result.getLastName());
	}
	
	@Test
	public void testDelete(){
		Student created = studentHandler.save(RandomModelCreator.createStudent());
		studentHandler.delete(created.getId());
		Student building = studentHandler.findOne(created.getId());
		assertNull(building);
	}
}
