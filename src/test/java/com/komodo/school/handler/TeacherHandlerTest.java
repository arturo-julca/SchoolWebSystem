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
import com.komodo.school.model.Teacher;
import com.komodo.school.util.RandomModelCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestPersistenceConfiguration.class})
public class TeacherHandlerTest {

	@Autowired
	private TeacherHandler teacherHandler;
	
	@Test
	public void testSave(){
		Teacher semester = RandomModelCreator.createTeacher();
		Teacher result = teacherHandler.save(semester);
		assertNotNull(result);
		assertEquals(semester.getFirstName(), result.getFirstName());
		assertEquals(semester.getLastName(), result.getLastName());
		assertEquals(semester.getCode(), result.getCode());
	}
	
	@Test
	public void testFindAll(){
		teacherHandler.save(RandomModelCreator.createTeacher());
		List<Teacher> listBuilding = teacherHandler.findAll();
		assertNotNull(listBuilding);
		assertTrue(!listBuilding.isEmpty());
	}
	
	@Test
	public void testFindOne(){
		Teacher created = teacherHandler.save(RandomModelCreator.createTeacher());
		Teacher result = teacherHandler.findOne(created.getId());
		assertNotNull(result);
		assertEquals(created.getFirstName(), result.getFirstName());
		assertEquals(created.getLastName(), result.getLastName());
		assertEquals(created.getCode(), result.getCode());
	}
	
	@Test
	public void testUpdate(){
		Teacher created = teacherHandler.save(RandomModelCreator.createTeacher());
		created.setFirstName("updated name");
		created.setLastName("updated last name");
		created.setCode("updated code");
		Teacher result = teacherHandler.update(created.getId(), created);
		assertNotNull(result);
		assertEquals(created.getFirstName(), result.getFirstName());
		assertEquals(created.getLastName(), result.getLastName());
		assertEquals(created.getCode(), result.getCode());
	}
	
	@Test
	public void testDelete(){
		Teacher created = teacherHandler.save(RandomModelCreator.createTeacher());
		teacherHandler.delete(created.getId());
		Teacher teacher = teacherHandler.findOne(created.getId());
		assertNull(teacher);
	}
}
