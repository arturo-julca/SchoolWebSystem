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
import com.komodo.school.model.Course;
import com.komodo.school.util.RandomModelCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestPersistenceConfiguration.class})
public class CourseHandlerTest {

	@Autowired
	private CourseHandler courseHandler;
	
	@Test
	public void testHandlerOperations(){
		Course course = RandomModelCreator.createCourse();
		Course result = courseHandler.save(course);
		assertNotNull(result);
		assertEquals(course.getCode(), result.getCode());
	}
	
	@Test
	public void testFindAll(){
		courseHandler.save(RandomModelCreator.createCourse());
		List<Course> listBuilding = courseHandler.findAll();
		assertNotNull(listBuilding);
		assertTrue(!listBuilding.isEmpty());
	}
	
	@Test
	public void testFindOne(){
		Course created = courseHandler.save(RandomModelCreator.createCourse());
		Course result = courseHandler.findOne(created.getId());
		assertNotNull(result);
		assertEquals(created.getCode(), result.getCode());
	}
	
	@Test
	public void testUpdate(){
		Course created = courseHandler.save(RandomModelCreator.createCourse());
		created.setName("updated name");
		created.setCode("updated code");
		Course result = courseHandler.update(created.getId(), created);
		assertNotNull(result);
		assertEquals(created.getName(), result.getName());
		assertEquals(created.getCode(), result.getCode());
	}
	
	@Test
	public void testDelete(){
		Course created = courseHandler.save(RandomModelCreator.createCourse());
		courseHandler.delete(created.getId());
		Course building = courseHandler.findOne(created.getId());
		assertNull(building);
	}
}
