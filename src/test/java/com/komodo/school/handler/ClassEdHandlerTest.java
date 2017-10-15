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
import com.komodo.school.model.ClassEd;
import com.komodo.school.model.Course;
import com.komodo.school.model.Room;
import com.komodo.school.model.Semester;
import com.komodo.school.model.Teacher;
import com.komodo.school.util.RandomModelCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestPersistenceConfiguration.class})
public class ClassEdHandlerTest {
	
	@Autowired
	private ClassEdHandler classEdHandler;
	
	@Autowired
	private CourseHandler courseHandler;
	
	@Autowired
	private TeacherHandler teacherHandler;
	
	@Autowired
	private SemesterHandler semesterHandler;
	
	@Autowired
	private RoomHandler roomHandler;
	
	@Autowired
	private BuildingHandler buildingHandler;
	
	private ClassEd getSavedClassEd(ClassEd classEd){
		Course courseCreated = courseHandler.save(RandomModelCreator.createCourse());
		Teacher teacherCreated = teacherHandler.save(RandomModelCreator.createTeacher());
		Semester semesterCreated = semesterHandler.save(RandomModelCreator.createSemester());
		Building buildingCreated = buildingHandler.save(RandomModelCreator.createBuilding());
		Room roomCreated = roomHandler.save(RandomModelCreator.createRoom(), buildingCreated.getId());
		ClassEd savedClassEd = classEdHandler.save(classEd, courseCreated.getId(), teacherCreated.getId(), semesterCreated.getId(), roomCreated.getId());
		return savedClassEd;
	}
	
	@Test
	public void testUpdate(){
		ClassEd created = RandomModelCreator.createClassEd();
		ClassEd saved = getSavedClassEd(created);
		saved.setCode("2017-test");
		ClassEd updated = classEdHandler.update(saved.getId(), saved);
		assertNotNull(saved);
		assertEquals(updated.getCode(), saved.getCode());
	}
	
	@Test
	public void testSave(){
		ClassEd created = RandomModelCreator.createClassEd();
		ClassEd saved = getSavedClassEd(created);
		assertNotNull(saved);
		assertEquals(saved.getCode(), created.getCode());
	}
	
	@Test
	public void testFindAll(){
		getSavedClassEd(RandomModelCreator.createClassEd());
		List<ClassEd> listFinded = classEdHandler.findAll();
		assertNotNull(listFinded);
		assertTrue(!listFinded.isEmpty());
	}
	
	@Test
	public void testFindOne(){
		ClassEd saved = getSavedClassEd(RandomModelCreator.createClassEd());
		ClassEd finded = classEdHandler.findOne(saved.getId());
		assertNotNull(finded);
		assertNotNull(finded.getId());
		assertEquals(finded.getCode(), saved.getCode());
	}
	
	@Test
	public void testDelete(){
		ClassEd saved = getSavedClassEd(RandomModelCreator.createClassEd());
		classEdHandler.delete(saved.getId());
		ClassEd result = classEdHandler.findOne(saved.getId());
		assertNull(result);
	}
}
