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
import com.komodo.school.model.Semester;
import com.komodo.school.util.RandomModelCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestPersistenceConfiguration.class})
public class SemesterHandlerTest {

	@Autowired
	private SemesterHandler semesterHandler;
	
	@Test
	public void testSave(){
		Semester semester = RandomModelCreator.createSemester();
		Semester result = semesterHandler.save(semester);
		assertNotNull(result);
		assertEquals(semester.getName(), result.getName());
	}
	
	@Test
	public void testFindAll(){
		semesterHandler.save(RandomModelCreator.createSemester());
		List<Semester> listBuilding = semesterHandler.findAll();
		assertNotNull(listBuilding);
		assertTrue(!listBuilding.isEmpty());
	}
	
	@Test
	public void testFindOne(){
		Semester created = semesterHandler.save(RandomModelCreator.createSemester());
		Semester result = semesterHandler.findOne(created.getId());
		assertNotNull(result);
		assertEquals(created.getName(), result.getName());
	}
	
	@Test
	public void testUpdate(){
		Semester created = semesterHandler.save(RandomModelCreator.createSemester());
		created.setName("updated name");
		Semester result = semesterHandler.update(created.getId(), created);
		assertNotNull(result);
		assertEquals(created.getName(), result.getName());
	}
	
	@Test
	public void testDelete(){
		Semester created = semesterHandler.save(RandomModelCreator.createSemester());
		semesterHandler.delete(created.getId());
		Semester semester = semesterHandler.findOne(created.getId());
		assertNull(semester);
	}
}
